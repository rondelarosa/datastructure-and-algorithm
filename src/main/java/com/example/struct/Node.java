package com.example.struct;

public class Node {
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    private Node nextNode;

    @Override
    public String toString() {
        return "data: " + this.data;
    }
}
