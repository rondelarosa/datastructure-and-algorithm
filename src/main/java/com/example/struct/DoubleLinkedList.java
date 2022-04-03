package com.example.struct;

import java.util.StringJoiner;

public class DoubleLinkedList {
    private DoubleLinkedNode head;

    public DoubleLinkedNode getHead() {
        return head;
    }

    /**
     * Big O notation of 1 > O(1)
     */
    public void insertAtHead(int data) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(data);
        newNode.setNextNode(this.head);
        if(this.head != null) {
            this.head.setPreviousNode(newNode);
        }
        this.head = newNode;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "{", "}");
        DoubleLinkedNode current = this.head;

        while (current != null) {
            result.add(current.toString());
            current = current.getNextNode();
        }

        return result.toString();
    }

    public int length() {
        int length = 0;
        DoubleLinkedNode current = this.head;

        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    /**
     * Big O notation of 1 > O(1)
     */
    public void deleteFromHead() {
        this.head = this.head.getNextNode();
    }

    /**
     * Big O notation of n > O(n)
     */
    public DoubleLinkedNode find(int data) {
        DoubleLinkedNode current = this.head;

        while (current != null) {
            if (current.getData() == data) return current;
            current = current.getNextNode();
        }
        return null;
    }
}
