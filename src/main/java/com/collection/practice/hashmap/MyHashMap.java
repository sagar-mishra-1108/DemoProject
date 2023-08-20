package com.collection.practice.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 16;
    private final List<LinkedList<Entry<K, V>>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(INITIAL_SIZE);
        IntStream.range(0, INITIAL_SIZE).forEach(i -> buckets.add(new LinkedList<>()));
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.size();
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.addLast(new Entry<>(key, value));
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "buckets=" + buckets +
                '}';
    }

    public static void main(String ...args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("key1", 10);
        myHashMap.put("key2", 20);
        myHashMap.put("key3", 30);
        myHashMap.put("key4", 40);

        System.out.println(myHashMap);
        System.out.println("Value of key1 is: " + myHashMap.get("key1"));
        System.out.println("Value of key5 is: " + myHashMap.get("key5"));
        System.out.println("Does of key6 exists: " + myHashMap.containsKey("key6"));
    }
}
