package dev.Innocent.InMemoryCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class InMemoryCache<K, V> {

    private final int maxSize;
    private final long ttlNanos;

    private final Map<K, Entry<V>> entries;

    private static final class Entry<V> {
        private final V value;
        private final long expiresAt;

        private Entry(V value, long expiresAt) {
            this.value = value;
            this.expiresAt = expiresAt;
        }
    }

    public InMemoryCache(int maxSize, long ttlNanos) {

        if (maxSize <= 0) {
            throw new IllegalArgumentException(
                    "Maximum size must be greater than zero"
            );
        }

        if (ttlNanos <= 0) {
            throw new IllegalArgumentException(
                    "TTL must be greater than zero"
            );
        }

        this.maxSize = maxSize;
        this.ttlNanos = ttlNanos;

        // accessOrder = true enables LRU tracking.
        this.entries = new LinkedHashMap<>(16, 0.75f, true);
    }

    public synchronized void put(K key, V value) {

        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(value, "Value cannot be null");

        long now = System.nanoTime();

        removeExpiredEntries(now);

        // Updating an existing key doesn't increase cache size.
        entries.remove(key);

        // Evict least recently used entry if capacity is reached.
        if (entries.size() >= maxSize) {
            Iterator<K> iterator = entries.keySet().iterator();

            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }

        long expiresAt = now + ttlNanos;

        entries.put(key, new Entry<>(value, expiresAt));
    }

    public synchronized V get(K key) {

        Objects.requireNonNull(key, "Key cannot be null");

        Entry<V> entry = entries.get(key);

        if (entry == null) {
            return null;
        }

        if (isExpired(entry, System.nanoTime())) {
            entries.remove(key);
            return null;
        }

        // LinkedHashMap automatically updates access order.
        return entry.value;
    }

    public synchronized void remove(K key) {
        entries.remove(Objects.requireNonNull(key));
    }

    public synchronized int size() {
        removeExpiredEntries(System.nanoTime());
        return entries.size();
    }

    public synchronized void clear() {
        entries.clear();
    }

    private boolean isExpired(Entry<V> entry, long now) {
        return now - entry.expiresAt >= 0;
    }

    private void removeExpiredEntries(long now) {

        Iterator<Map.Entry<K, Entry<V>>> iterator =
                entries.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<K, Entry<V>> entry = iterator.next();

            if (isExpired(entry.getValue(), now)) {
                iterator.remove();
            }
        }
    }
}
