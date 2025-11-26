package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }


    public void insert(Integer data) {
        root = insertRec(root, data);
    }

    private BstNode insertRec(BstNode node, Integer data) {
        if (node == null) {
            return new BstNode(data);
        }
        if (data < node.getData()) {
            node.setLeft(insertRec(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insertRec(node.getRight(), data));
        }
        return node;
    }


    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(BstNode node) {
        if (node == null) return;
        inOrderRec(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderRec(node.getRight());
    }


    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(BstNode node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        preOrderRec(node.getLeft());
        preOrderRec(node.getRight());
    }


    public void postOrderTraversal() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(BstNode node) {
        if (node == null) return;
        postOrderRec(node.getLeft());
        postOrderRec(node.getRight());
        System.out.print(node.getData() + " ");
    }


    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<BstNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BstNode node = q.poll();
            System.out.print(node.getData() + " ");

            if (node.getLeft() != null) q.add(node.getLeft());
            if (node.getRight() != null) q.add(node.getRight());
        }
        System.out.println();
    }


    public int getDepth(BstNode node) {
        return getDepthRec(root, node, 0);
    }

    private int getDepthRec(BstNode current, BstNode target, int depth) {
        if (current == null) return -1;
        if (current == target) return depth;

        int left = getDepthRec(current.getLeft(), target, depth + 1);
        if (left != -1) return left;

        return getDepthRec(current.getRight(), target, depth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print =====\n");
        printRec(root, "", true);
        System.out.println();
    }

    private void printRec(BstNode node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getData());

        if (node.getLeft() != null || node.getRight() != null) {
            if (node.getLeft() != null)
                printRec(node.getLeft(), prefix + (isTail ? "    " : "│   "), false);
            if (node.getRight() != null)
                printRec(node.getRight(), prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
