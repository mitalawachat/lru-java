import java.util.Iterator;

public class LRUIterator<K, V> implements Iterator<V> {

    private LRU.Entry<K, V> entry;

    public LRUIterator(LRU.Entry<K, V> entry) {
        this.entry = entry;
    }

    @Override
    public boolean hasNext() {
        return entry != null && entry.next != null;
    }

    @Override
    public V next() {
        V value = entry.value;
        entry = entry.next;
        return value;
    }
}
