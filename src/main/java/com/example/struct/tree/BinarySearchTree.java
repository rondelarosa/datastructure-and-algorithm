package com.example.struct.tree;

public class BinarySearchTree {
    Node root;

    public void insert(int value) {
        insert(this.root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            root = new Node();
            root.data = value;
        } else if (value < root.data) {
            // insert on left
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            // insert on right
            root.right = insert(root.right, value);
        }

        return root;
    }

    public boolean contains(int value) {
        return contains(this.root, value);
    }

    public boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.data) {
            return contains(node.left, value);
        }

        if (value > node.data) {
            return contains(node.right, value);
        }

        return true;
    }
}
