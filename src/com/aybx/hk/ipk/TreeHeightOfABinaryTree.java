package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class TreeHeightOfABinaryTree {

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static int height(Node root) {
        if (root == null) return -1;
        int x = Math.max(height(root.left), height(root.right));
        return x + 1;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = in.nextInt();
            root = insert(root, data);
        }
        int height = height(root);
        out.println(height);
    }

    private static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
