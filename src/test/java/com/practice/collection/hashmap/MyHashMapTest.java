package com.practice.collection.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.practice.collection.hashmap.MyHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {

    MyHashMap<String, Integer> myHashMap;

    @BeforeEach
    public void setup() {
        myHashMap = new MyHashMap<>();
    }

    @Test
    public void testMyHashMap() {
        myHashMap.put("key1", 10);
        myHashMap.put("key2", 20);
        myHashMap.put("key3", 30);
        myHashMap.put("key4", 40);
        myHashMap.put("key1", 90);

        assertEquals(90, myHashMap.get("key1"));
        assertEquals(40, myHashMap.get("key4"));
        assertNull(myHashMap.get("key5"));
        assertTrue(myHashMap.containsKey("key2"));
        assertFalse(myHashMap.containsKey("key9"));
    }

}