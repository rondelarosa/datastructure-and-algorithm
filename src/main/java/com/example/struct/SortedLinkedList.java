package com.example.struct;

import java.util.StringJoiner;

public class SortedLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Big O notation of n > O(n)
     */
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        }

        Node current = this.head;

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
        Node current = this.head;

        while (current != null) {
            result.add(current.toString());
            current = current.getNextNode();
        }

        return result.toString();
    }

    public int length() {
        int length = 0;
        Node current = this.head;

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
    public Node find(int data) {
        Node current = this.head;

        while (current != null) {
            if (current.getData() == data) return current;
            current = current.getNextNode();
        }
        return null;
    }
}
