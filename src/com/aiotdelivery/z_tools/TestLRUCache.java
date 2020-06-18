package com.aiotdelivery.z_tools;

public class TestLRUCache {
    public static void main(String[] args) {
        LC0146_LRUCache cache = new LC0146_LRUCache(2);
        cache.put(1, 1);
        cache.show();
        cache.put(2, 2);
        cache.show();
        System.out.println("cache.get(1) = " + cache.get(1)); // returns 1
        cache.show();
        cache.put(3, 3);    // evicts key 2
        cache.show();
        System.out.println("cache.get(2) = " + cache.get(2)); // returns -1 (not found)
        cache.show();
        cache.put(4, 4);    // evicts key 1
        cache.show();
        System.out.println("cache.get(1) = " + cache.get(1)); // returns -1 (not found)
        cache.show();
        System.out.println("cache.get(3) = " + cache.get(3)); // returns 3
        cache.show();
        System.out.println("cache.get(4) = " + cache.get(4)); // returns 4
        cache.show();
    }
}
