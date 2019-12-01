import java.util.Iterator;

public class LRUExample {
    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU<>(3);
        print(lru);

        lru.put(1, 1);
        print(lru);

        lru.put(2, 2);
        print(lru);

        lru.put(2, 22);
        print(lru);

        lru.put(3, 3);
        print(lru);

        lru.put(1, 11);
        print(lru);

        lru.put(4, 4);
        print(lru);

        lru.put(4, 44);
        print(lru);

        lru.put(5, 5);
        print(lru);

        lru.put(5, 55);
        print(lru);

        lru.put(4, 444);
        print(lru);

        lru.remove(1);
        print(lru);

        lru.remove(2);
        print(lru);

        lru.remove(3);
        print(lru);

        lru.remove(4);
        print(lru);

        lru.put(1, 1);
        print(lru);

        lru.put(1, 11);
        print(lru);

        lru.put(2, 2);
        print(lru);

        lru.put(2, 22);
        print(lru);
    }

    private static void print(LRU<Integer, Integer> lru) {
        Iterator<Integer> iterator = lru.valueIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
