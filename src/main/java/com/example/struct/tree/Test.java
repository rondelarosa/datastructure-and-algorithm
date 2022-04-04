package com.example.struct.tree;

public class Test {

    public static void binaryTree() {

        //          5
        //       2        4
        //    9    10  7

        Node rootNode = new Node();
        rootNode.data = 5;
        Node nodeTwo = new Node();
        nodeTwo.data = 2;
        Node nodeFour = new Node();
        nodeFour.data = 4;
        Node nodeNine = new Node();
        nodeNine.data = 9;
        Node nodeTen = new Node();
        nodeTen.data = 10;
        Node nodeSeven = new Node();
        nodeSeven.data = 7;

        rootNode.left = nodeTwo;
        rootNode.right = nodeFour;
        nodeTwo.left = nodeNine;
        nodeTwo.right = nodeTen;
        nodeFour.left = nodeSeven;

        BinaryTree tree = new BinaryTree();
        tree.root = rootNode;

        tree.preOrderTraversal();
        System.out.println();

        tree.inOrderTraversal();
        System.out.println();

        tree.postOrderTraversal();
        System.out.println();

    }

    public static void binarySearchTree() {

        Node rootNode = new Node();
        rootNode.data = 2;

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = rootNode;

        tree.insert(1);
        tree.insert(3);
        tree.insert(4);

        System.out.println("search 1: " + tree.contains(1));
        System.out.println("search 2: " + tree.contains(2));
        System.out.println("search 3: " + tree.contains(3));
        System.out.println("search 100: " + tree.contains(100));
    }
}
