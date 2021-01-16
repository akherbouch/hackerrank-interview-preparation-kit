package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaximumXor {

    private static class Node {
        int value = -1;
        Node zero, one;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        Node trieRoot = new Node();
        for (int i = 0; i<n; i++) {
            a[i] = in.nextInt();
            Node node = trieRoot;
            long mask = 31;
            while (mask >= 0) {
                int bit = a[i] >> mask;
                if ((bit & 1) == 1) {
                    if (node.one == null) node.one = new Node();
                    node = node.one;
                } else {
                    if (node.zero == null) node.zero = new Node();
                    node = node.zero;
                }
                mask--;
            }
            node.value = a[i];
        }

        int q = in.nextInt();
        while (q-- > 0) {
            int m = in.nextInt();
            Node node = trieRoot;
            int mask = 31;
            while (mask >= 0) {
                if (node.one == null) node = node.zero;
                else if (node.zero == null) node = node.one;
                else {
                    int bit = m >> mask;
                    node = (bit & 1) == 1 ? node.zero : node.one;
                }
                mask--;
            }
            int ans = node.value ^ m;
            out.println(ans);
        }
    }
}
