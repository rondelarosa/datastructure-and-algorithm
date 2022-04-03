package com.example.struct;

import java.util.StringJoiner;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
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
}
