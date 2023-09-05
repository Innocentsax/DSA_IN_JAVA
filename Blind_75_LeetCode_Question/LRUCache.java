/*
Implement an LRUCache class for a Least Recently Used (LRU) cache. The class should support:

Inserting key-value pairs with the insertKeyValuePair method.
Retrieving a key's value with the getValueFromKey method.
Retrieving the most recently used (the most recently inserted or retrieved) key with 
the getMostRecentKey method.
Try to implement each of these methods to run in constant time.

Additionally, the LRUCache class should store a maxSize property set 
to the size of the cache, 
which is passed in as an argument during instantiation. This size 
represents the maximum number 
of key-value pairs that the cache can store at once. If a key-value 
pair is inserted in the cache 
when it has reached maximum capacity, the least recently used 
key-value pair should be evicted from
the cache and no longer retrievable; the newly added key-value 
pair should effectively replace it.

Note that inserting a key-value pair with an already existing key should 
simply replace the key's 
value in the cache with the new value and shouldn't evict a key-value pair 
if the cache is full. Lastly, attempting to retrieve a value from a key 
that isn't in the cache should return None / null.

Sample Usage
// All operations below are performed sequentially.
LRUCache(3): - // instantiate an LRUCache of size 3
insertKeyValuePair("b", 2): -
insertKeyValuePair("a", 1): -
insertKeyValuePair("c", 3): -
getMostRecentKey(): "c" // "c" was the most recently inserted key
getValueFromKey("a"): 1
getMostRecentKey(): "a" // "a" was the most recently retrieved key
insertKeyValuePair("d", 4): - // the cache had 3 entries; the least recently 
used one is evicted
getValueFromKey("b"): None // "b" was evicted in the previous operation
insertKeyValuePair("a", 5): - // "a" already exists in the cache so its 
value just gets replaced
getValueFromKey("a"): 5
*/

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


======> Test =======

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;

public class ProgramTest {
  @Test
  public void TestCase1() {
    Program.LRUCache lruCache = new Program.LRUCache(3);

    lruCache.insertKeyValuePair("b", 2);
    lruCache.insertKeyValuePair("a", 1);
    lruCache.insertKeyValuePair("c", 3);

    assertTrue(lruCache.getMostRecentKey() == "c");
    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getMostRecentKey() == "a");

    lruCache.insertKeyValuePair("d", 4);

    var evictedValue = lruCache.getValueFromKey("b");

    assertTrue(evictedValue == null || evictedValue.found == false);

    lruCache.insertKeyValuePair("a", 5);

    assertTrue(lruCache.getValueFromKey("a").value == 5);
  }
  
  @Test
  public void TestCase2() {
    Program.LRUCache lruCache = new Program.LRUCache(1);

    assertTrue(lruCache.getValueFromKey("a").found == false);

    lruCache.insertKeyValuePair("a", 1);

    assertTrue(lruCache.getValueFromKey("a").value == 1);

    lruCache.insertKeyValuePair("a", 9001);

    assertTrue(lruCache.getValueFromKey("a").value == 9001);

    lruCache.insertKeyValuePair("b", 2);

    assertTrue(lruCache.getValueFromKey("a").value == null);
    assertTrue(lruCache.getValueFromKey("b").value == 2);

    lruCache.insertKeyValuePair("c", 3);

    assertTrue(lruCache.getValueFromKey("a").value == null);
    assertTrue(lruCache.getValueFromKey("b").value == null);
    assertTrue(lruCache.getValueFromKey("c").value == 3);
  }

  @Test
  public void TestCase3() {
    Program.LRUCache lruCache = new Program.LRUCache(4);

    lruCache.insertKeyValuePair("a", 1);
    lruCache.insertKeyValuePair("b", 2);
    lruCache.insertKeyValuePair("c", 3);
    lruCache.insertKeyValuePair("d", 4);

    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getValueFromKey("b").value == 2);
    assertTrue(lruCache.getValueFromKey("c").value == 3);
    assertTrue(lruCache.getValueFromKey("d").value == 4);

    lruCache.insertKeyValuePair("e", 5);

    assertTrue(lruCache.getValueFromKey("a").found == false);
    assertTrue(lruCache.getValueFromKey("b").value == 2);
    assertTrue(lruCache.getValueFromKey("c").value == 3);
    assertTrue(lruCache.getValueFromKey("d").value == 4);
    assertTrue(lruCache.getValueFromKey("e").value == 5);
  }

  @Test
  public void TestCase4() {
    Program.LRUCache lruCache = new Program.LRUCache(4);

    lruCache.insertKeyValuePair("a", 1);

    assertTrue(lruCache.getMostRecentKey() == "a");

    lruCache.insertKeyValuePair("b", 2);

    assertTrue(lruCache.getMostRecentKey() == "b");

    lruCache.insertKeyValuePair("c", 3);

    assertTrue(lruCache.getMostRecentKey() == "c");

    lruCache.insertKeyValuePair("d", 4);

    assertTrue(lruCache.getMostRecentKey() == "d");

    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getMostRecentKey() == "a");

    assertTrue(lruCache.getValueFromKey("b").value == 2);
    assertTrue(lruCache.getMostRecentKey() == "b");

    assertTrue(lruCache.getValueFromKey("c").value == 3);
    assertTrue(lruCache.getMostRecentKey() == "c");

    assertTrue(lruCache.getValueFromKey("d").value == 4);
    assertTrue(lruCache.getMostRecentKey() == "d");

    lruCache.insertKeyValuePair("e", 5);

    assertTrue(lruCache.getMostRecentKey() == "e");
  }

  @Test
  public void TestCase5() {
    Program.LRUCache lruCache = new Program.LRUCache(4);

    lruCache.insertKeyValuePair("a", 1);
    lruCache.insertKeyValuePair("b", 2);
    lruCache.insertKeyValuePair("c", 3);
    lruCache.insertKeyValuePair("d", 4);

    assertTrue(lruCache.getValueFromKey("a").value == 1);

    lruCache.insertKeyValuePair("e", 5);

    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getValueFromKey("b").found == false);
    assertTrue(lruCache.getValueFromKey("c").value == 3);

    lruCache.insertKeyValuePair("f", 5);

    assertTrue(lruCache.getValueFromKey("c").value == 3);
    assertTrue(lruCache.getValueFromKey("d").found == false);

    lruCache.insertKeyValuePair("g", 5);

    assertTrue(lruCache.getValueFromKey("e").found == false);
    assertTrue(lruCache.getValueFromKey("a").value == 1);
    assertTrue(lruCache.getValueFromKey("c").value == 3);
    assertTrue(lruCache.getValueFromKey("f").value == 5);
    assertTrue(lruCache.getValueFromKey("g").value == 5);
  }
}
