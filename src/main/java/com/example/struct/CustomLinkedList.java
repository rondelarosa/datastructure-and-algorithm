package com.example.struct;

public class CustomLinkedList {

    Node head;

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void displayContents() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public void deleteKthNodeFromEnd(int k) {

        if (head == null || k == 0) {
            return;
        }

        // list = [a, b, c, d]; k = 2
        Node first = head; // a
        Node second = head; // a

        for (int i = 0; i < k; i++) {
            second = second.next;
            if (second.next == null) {
                // K >= length of list
                if (i == k - 1) {
                    head = head.next;
                }
                return;
            }
        }

        // second = c

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        // first = b
        // second = d

        first.next = first.next.next; // this will disconnect deleted nodes

    }

    public void deleteNode(int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            second = second.next;
            if (second.next == null) {
                // K >= length of linked list
                if (i == k - 1) {
                    head = head.next;
                    return;
                }
            }
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
    }

    public static void example() {
        CustomLinkedList linkedList = new CustomLinkedList();

        Node firstNode = new Node(3);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(5);
        Node fourthNode = new Node(6);

        linkedList.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        linkedList.displayContents();
        linkedList.deleteKthNodeFromEnd(2);
        linkedList.displayContents();
    }

    public static void challenge() {
        CustomLinkedList linkedList = new CustomLinkedList();

        Node firstNode = new Node(5);
        Node secondNode = new Node(7);
        Node thirdNode = new Node(11);
        Node fourthNode = new Node(2);
        Node fifthNode = new Node(18);

        linkedList.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        linkedList.displayContents();
        linkedList.deleteNode(2);
        linkedList.displayContents();
    }
}
