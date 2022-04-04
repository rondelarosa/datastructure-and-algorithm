package com.example.struct;

public class Node2 {
    private int data;

    public Node2(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2 getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node2 nextNode) {
        this.nextNode = nextNode;
    }

    private Node2 nextNode;

    @Override
    public String toString() {
        return "data: " + this.data;
    }
}
