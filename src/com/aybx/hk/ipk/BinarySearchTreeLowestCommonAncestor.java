package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class BinarySearchTreeLowestCommonAncestor {

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

    public static Node lca(Node root, int v1, int v2) {
        if (v1 < root.data && v2 < root.data)
            return lca(root.left, v1, v2);
        if (v1 > root.data && v2 > root.data)
            return lca(root.right, v1, v2);
        return root;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = in.nextInt();
            root = insert(root, data);
        }
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        Node ans = lca(root,v1,v2);
        out.println(ans.data);
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
