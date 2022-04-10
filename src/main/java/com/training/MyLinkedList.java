package com.training;

public class MyLinkedList<T> {
    private MyNode<T> head;

    private int length = 0;

    public MyNode<T> getHead() {
        return this.head;
    }

    public int length() {
        return this.length;
    }

    public void add(T data) {
        MyNode<T> node = new MyNode<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            MyNode<T> x = this.head;
            while (x.getNext() != null) {
                x = x.getNext();
            }
            x.setNext(node);
        }
        this.length++;
    }
}
