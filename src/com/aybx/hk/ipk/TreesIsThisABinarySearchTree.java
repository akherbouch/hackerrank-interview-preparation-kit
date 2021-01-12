package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class TreesIsThisABinarySearchTree {

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
    boolean checkBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return checkBST(root.left, min, root.data) &&
                checkBST(root.right, root.data, max);
    }

    boolean checkBST(Node root) {
       return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }



    public void solve(int testNumber, Scanner in, PrintWriter out) {
    }
}
