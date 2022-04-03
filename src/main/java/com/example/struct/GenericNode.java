package com.example.struct;

public class GenericNode<T> {
    private T data;
    private GenericNode<T> nextGenericNode;

    public GenericNode(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public GenericNode<T> getNextGenericNode() {
        return nextGenericNode;
    }

    public void setNextGenericNode(GenericNode<T> nextGenericNode) {
        this.nextGenericNode = nextGenericNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
