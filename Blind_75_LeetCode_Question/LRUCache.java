import java.util.*;

class Program {
    static class LRUCache {
        int maxSize;
        LinkedHashMap<String, Integer> cache;
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            this.cache = new LinkedHashMap<>(maxSize, 0.75f, true);
            this.head = new DoublyLinkedListNode(null, 0);
            this.tail = new DoublyLinkedListNode(null, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void insertKeyValuePair(String key, int value) {
            if (cache.size() >= maxSize) {
                evictLeastRecentlyUsed();
            }
            cache.put(key, value);
            addToFront(new DoublyLinkedListNode(key, value));
        }

        public LRUResult getValueFromKey(String key) {
            Integer value = cache.get(key);
            if (value != null) {
                moveToHead(key);
                return new LRUResult(true, value);
            }
            return new LRUResult(false, null);
        }

        public String getMostRecentKey() {
            if (head.next != tail) {
                return head.next.key;
            }
            return null;
        }

        private void evictLeastRecentlyUsed() {
            String keyToRemove = tail.prev.key;
            cache.remove(keyToRemove);
            removeNode(tail.prev);
        }

        private void addToFront(DoublyLinkedListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DoublyLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(String key) {
            DoublyLinkedListNode node = head.next;
            while (node != tail) {
                if (node.key.equals(key)) {
                    removeNode(node);
                    addToFront(node);
                    break;
                }
                node = node.next;
            }
        }
    }

    static class DoublyLinkedListNode {
        String key;
        int value;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;

        public DoublyLinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUResult {
        boolean found;
        Integer value;

        public LRUResult(boolean found, Integer value) {
            this.found = found;
            this.value = value;
        }
    }
}
