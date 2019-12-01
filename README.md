# LRU (Java)

LRU `(Least Recently Used)` cache allows you to store memory bounded data with auto-eviction policy for least recently used entries once the maximum capacity is reached.

## Requirement

* Fixed Size
* Fast Read
* Fast Add
* Fast Updates

## Internal Data Structure

* `HashMap` is used for O(1) operations on get(key) and put(key, value).
* `Doubly Linked List` is used because it supports fast insertion and deletion of nodes.

## Constructor

* `public LRU(int capacity)`

## Public Methods

* `public LRU(int capacity)`
* `public void put(K key, V value)`
* `public V get(K key)`
* `public V remove(K key)`
* `public List<V> getValues()`
* `public Iterator<V> valueIterator()`

## Private Methods

* `private void addFront(Entry<K, V> entry)`
* `private void moveFront(Entry<K, V> entry)`
* `private void delete(Entry<K, V> entry)`
* `private void ensureCapacity()`

## Strength

* Fast Access
* Fast Updates

## Weakness

* Space Heavy
