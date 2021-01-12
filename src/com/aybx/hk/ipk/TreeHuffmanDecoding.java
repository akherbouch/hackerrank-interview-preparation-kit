package com.aybx.hk.ipk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class TreeHuffmanDecoding {


    void decode(String s, Node root) {
        StringBuilder out = new StringBuilder();
        int n = s.length();
        Node curNode = root;
        for (int i = 0; i<n; i++) {
            boolean left = s.charAt(i) - '0' == 0;
            if (left) curNode = curNode.left;
            else curNode = curNode.right;
            if (curNode.data != '\0') {
                out.append(curNode.data);
                curNode = root;
            }
        }
        System.out.println(out.toString());
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
    }

    abstract class Node implements Comparable<Node> {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
        public Node(int freq) {
            frequency = freq;
        }

        // compares on the frequency
        public int compareTo(Node tree) {
            return frequency - tree.frequency;
        }
    }

}
