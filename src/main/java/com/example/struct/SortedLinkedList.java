package com.example.struct;

import java.util.StringJoiner;

public class SortedLinkedList {
    private Node2 head;

    public Node2 getHead() {
        return head;
    }

    public void setHead(Node2 head) {
        this.head = head;
    }

    /**
     * Big O notation of n > O(n)
     */
    public void insertAtHead(int data) {
        Node2 newNode = new Node2(data);
        if (this.head == null) {
            this.head = newNode;
        }

        Node2 current = this.head;

        while (current != null) {
            // current node greater than new node and no next node
            if (current.getData() > data && current.getNextNode() == null) {
                newNode.setNextNode(current);
            }

            if (current.getData() < data && current.getNextNode() == null) {
                current.setNextNode(newNode);
            }

            // current node greater than new node and less than next node
            if (current.getData() > data && current.getNextNode() != null && current.getNextNode().getData() < data) {
                current.setNextNode(newNode);
                newNode.setNextNode(current.getNextNode());
            }

            current = current.getNextNode();
        }
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
