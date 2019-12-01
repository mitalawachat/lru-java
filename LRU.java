import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LRU<K, V> {

    public static class Entry<K, V> {

        K key;
        V value;
        Entry<K, V> previous;
        Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<K, Entry<K, V>> cache;
    private Entry<K, V> start;
    private Entry<K, V> end;
    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        start = new Entry<>();
        end = new Entry<>();
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Entry<K, V> entry = cache.get(key);
            entry.value = value;
            moveFront(entry);
        } else {
            Entry<K, V> entry = new Entry<>(key, value);
            ensureCapacity();
            addFront(entry);
        }
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Entry<K, V> entry = cache.get(key);
            moveFront(entry);
            return entry.value;
        }
        return null;
    }

    public V remove(K key) {
        if (cache.containsKey(key)) {
            Entry<K, V> entry = cache.get(key);
            delete(entry);
            return entry.value;
        }
        return null;
    }

    public List<V> getValues() {
        return cache.values().stream().map(c -> c.value).collect(Collectors.toCollection(ArrayList::new));
    }

    public Iterator<V> valueIterator() {
        return new LRUIterator<K, V>(this.start.next);
    }

    private void addFront(Entry<K, V> entry) {
        entry.previous = this.start;
        entry.next = this.start.next;
        if (start.next != null) {
            start.next.previous = entry;
        }
        start.next = entry;
        if (this.end.previous == null || this.end.previous == this.start) {
            this.end.previous = entry;
            entry.next = this.end;
        }
        cache.put(entry.key, entry);
    }

    private void moveFront(Entry<K, V> entry) {
        delete(entry);
        addFront(entry);
    }

    private void delete(Entry<K, V> entry) {
        if (cache.containsKey(entry.key)) {
            cache.remove(entry.key);
            entry.previous.next = entry.next;
            entry.next.previous = entry.previous;
        }
    }

    private void ensureCapacity() {
        if (cache.size() >= capacity) {
            Entry<K, V> entry = end.previous;
            delete(entry);
        }
    }
}
