package com.example.struct;

public class GenericSortedLinkedList<T extends Comparable<T>> {
    private GenericNode<T> head;

    public void insert(T data) {
        GenericNode<T> newGenericNode = new GenericNode<T>(data);
        if (this.head == null || this.head.getData().compareTo(data) > 0) {
            newGenericNode.setNextGenericNode(this.head);
            this.head = newGenericNode;
            return;
        }
        GenericNode<T> current = this.head;
        while (current != null && current.getNextGenericNode() != null
                && current.getNextGenericNode().getData().compareTo(data) < 0) {
            current = current.getNextGenericNode();
        }
        newGenericNode.setNextGenericNode(current.getNextGenericNode());
        current.setNextGenericNode(newGenericNode);
    }

    public GenericNode<T> getHead() {
        return this.head;
    }

    @Override
    public String toString() {
        String result = "[";
        GenericNode<T> current = this.head;
        while (current != null) {
            result += current.toString() + ", ";
            current = current.getNextGenericNode();
        }
        result += "]";
        return result;
    }
}
