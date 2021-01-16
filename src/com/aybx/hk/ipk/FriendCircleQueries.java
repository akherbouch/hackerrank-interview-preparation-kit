package com.aybx.hk.ipk;

import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class FriendCircleQueries {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        DisjointSet ds = new DisjointSet();
        int ans = 0;
        while (q-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int s = ds.union(a, b);
            ans = Math.max(ans, s);
            out.println(ans);
        }
    }

    private static class DisjointSet {
        HashMap<Integer, Integer> groupOf = new HashMap<>();
        HashMap<Integer, Integer> groupSize = new HashMap<>();

        public int findGroupOf(int a) {
            int g = groupOf.getOrDefault(a, a);
            if (a == g) return a;
            g = findGroupOf(g);
            groupOf.put(a, g);
            return g;
        }

        public int union(int a, int b) {
            int groupA = findGroupOf(a);
            int groupB = findGroupOf(b);
            int sizeA = groupSize.getOrDefault(groupA, 1);
            int sizeB = groupSize.getOrDefault(groupB, 1);
            if (groupA == groupB) return sizeA;
            if (sizeA >= sizeB) {
                groupOf.put(groupB, groupA);
                groupSize.put(groupA, sizeA + sizeB);
            } else {
                groupOf.put(groupA, groupB);
                groupSize.put(groupB, sizeA + sizeB);
            }
            return sizeA + sizeB;
        }
    }
}
