package com.aiotdelivery.z_tools;

import java.util.HashMap;
import java.util.Map;

public class LC0146_LRUCache {
    private Map<Integer, DoubleListNode> cacheMap = new HashMap<>();
    DoubleLinkedList cacheList = new DoubleLinkedList();
    private int capacity;

    public LC0146_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            DoubleListNode newNode = cacheMap.get(key);
            cacheList.moveToNew(newNode);
            return newNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DoubleListNode newNode = cacheMap.get(key);
            newNode.value = value;
            cacheList.moveToNew(newNode);
        } else {
            if (cacheMap.size() == capacity) {
                cacheMap.remove(cacheList.getTail().key);
                cacheList.removeOld();
            }
            DoubleListNode newNode = new DoubleListNode(key, value);
            cacheList.add(newNode);
            cacheMap.put(key,newNode);
        }
    }

    public void show() {
        cacheList.show();
    }
}
