package com.example.struct;

public class DoubleLinkedNode {
    private int data;
    private DoubleLinkedNode nextNode;
    private DoubleLinkedNode previousNode;

    public DoubleLinkedNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleLinkedNode previousNode) {
        this.previousNode = previousNode;
    }

    public void setNextNode(DoubleLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleLinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleLinkedNode getNextNode() {
        return nextNode;
    }


    @Override
    public String toString() {
        return "data: " + this.data;
    }
}
