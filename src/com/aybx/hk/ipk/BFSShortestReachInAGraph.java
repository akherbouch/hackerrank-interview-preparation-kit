package com.aybx.hk.ipk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;

public class BFSShortestReachInAGraph {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer>[] adj = new ArrayList[n];
            for (int i = 0; i<adj.length; i++) adj[i] = new ArrayList<>();
            while (m-- > 0) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            int s = in.nextInt() - 1;
            Queue<Integer> queue = new ArrayDeque<>();
            int[] distance = new int[n];
            for (int i = 0; i<n; i++) distance[i] = -1;
            queue.add(s);
            distance[s] = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int a : adj[cur]) {
                    if (distance[a] != -1) continue;
                    queue.add(a);
                    distance[a] = distance[cur] + 1;
                }
            }
            for (int i = 0; i<n; i++) {
                if (i == s) continue;
                int o = distance[i]*6;
                if (o < 0) o = -1;
                out.print(o+" ");
            }
            out.println();
        }
    }
}
