package com.aiotdelivery.z_tools;

public class DoubleLinkedList {
    private DoubleListNode start;
    private DoubleListNode end;
    public DoubleLinkedList() {
        start = new DoubleListNode(0,0);
        end = new DoubleListNode(0,0);
        start.next = end;
        end.pre = start;
    }

    public void add(DoubleListNode newNode) {
        DoubleListNode head = start.next;
        // start -> head ==> start -> newNode -> head
        newNode.pre = start;
        newNode.next = head;
        start.next = newNode;
        head.pre = newNode;
    }

    public void remove(DoubleListNode oldNode) {
        // pre -> oldNode -> next ==> pre -> next
        oldNode.pre.next = oldNode.next;
        oldNode.next.pre = oldNode.pre;
        oldNode.pre = null;
        oldNode.next = null;
    }

    public void moveToNew(DoubleListNode newNode) {
        remove(newNode);
        add(newNode);
    }

    public void removeOld() {
        if (end.pre==start) return;
        remove(end.pre);
    }

    public DoubleListNode getTail() {
        return end.pre;
    }

    public void show() {
        System.out.print("[");
        DoubleListNode now = start;
        while (now.next.next != null) {
            now = now.next;
            System.out.print("(" + now.key + ":" + now.value + ")->");
        }
        System.out.println("]");
    }
}
