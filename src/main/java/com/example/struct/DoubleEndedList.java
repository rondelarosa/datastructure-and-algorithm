package com.example.struct;

import java.util.StringJoiner;

public class DoubleEndedList {
    private Node2 head;
    private Node2 tail;


    /**
     * Big O notation of 1 > O(1)
     */
    public void insertAtHead(int data) {
        Node2 newNode = new Node2(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    /**
     * Big O notation of 1 > O(1)
     */
    public void insertAtTail(int data) {
        Node2 newNode = new Node2(data);
        if (this.head == null) {
            this.head = newNode;
        }

        if (this.tail != null) {
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "{", "}");
        Node2 current = this.head;

        while (current != null) {
            result.add(current.toString());
            current = current.getNextNode();
        }

        return result.toString();
    }

    public int length() {
        int length = 0;
        Node2 current = this.head;

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
    public Node2 find(int data) {
        Node2 current = this.head;

        while (current != null) {
            if (current.getData() == data) return current;
            current = current.getNextNode();
        }
        return null;
    }
}
