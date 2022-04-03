package com.example.struct;

import java.util.StringJoiner;

public class GenericSortedLinkedList<T extends Comparable<T>> {
    private GenericNode<T> head;

    public void insert(T data) {
        GenericNode<T> newNode = new GenericNode<T>(data);
        if (this.head == null || this.head.getData().compareTo(data) > 0) {
            newNode.setNextNode(this.head);
            this.head = newNode;
            return;
        }
        GenericNode<T> current = this.head;
        while (current != null && current.getNextNode() != null
                && current.getNextNode().getData().compareTo(data) < 0) {
            current = current.getNextNode();
        }
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
    }

    public GenericNode<T> getHead() {
        return this.head;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        GenericNode<T> current = this.head;
        while (current != null) {
            result.add(current.toString());
            current = current.getNextNode();
        }
        return result.toString();
    }
}
