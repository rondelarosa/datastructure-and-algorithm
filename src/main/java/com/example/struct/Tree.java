package com.example.struct;

/**
 * The tree structure is useful for working with nonlinear data.
 * The tree is collection of nodes, where each node might be linked to one, two or even more nodes.
 * Binary tree: each node has no more than two child nodes.
 * Binary search tree is a binary tree, but it adds the constraint of order. Right items must be greater than the parent and left must be less than.
 * Best case: O(log(n))
 * worst case: O(n)
 * Binary Tree: Tree traversal options: pre-order, in-order, post-order
 * in-order: Recursively visit left sub tree, visit root, recursively visit right sub tree. 5->2->8 (left), 2->11 (right), 5->7 (right) result: 8, 2,11, 5, 7. explores data sequentially
 * pre-order: Visit root, recursively visit left sub tree results: 5, 2, 8 , 11, 7
 * post-order: Recurse left sub tree, recurse right sub tree, visit root: results: 8, 11, 2, 7, 5
 *
 * In a tree traversal algorithm, each node in a tree is accessed particular order.
 */
public class Tree {
}
