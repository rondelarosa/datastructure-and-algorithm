package com.training;

public class MyNode<T> {
    public T data;
    private MyNode<T> next;

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return this.next;
    }

    public MyNode() {
    }

    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }
}
