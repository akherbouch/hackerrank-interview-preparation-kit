package com.aybx.hk.ipk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class MatrixDP {

    ArrayList<Edge>[] edges;
    boolean[] hasMachine;
    boolean[] visited;
    long[][] dp;
    final long oo = Long.MAX_VALUE - Integer.MAX_VALUE; // to avoid overflow while adding


    // using dfs to follow the topological sort
    private void dfs(int root, int parent) {
        long x = 0;
        int v,w;
        for (Edge edge : edges[root]) {
            v = edge.vertex;
            w = edge.weight;
            if (v == parent) continue;
            dfs(v, root);
            x += Math.min(dp[0][v], dp[1][v] + w);
        }
        if (hasMachine[root]) {
            dp[0][root] = oo;
            dp[1][root] = x;
            return;
        }
        dp[0][root] = x;
        dp[1][root] = oo;
        for (Edge edge : edges[root]) {
            v = edge.vertex;
            w = edge.weight;
            if (v == parent) continue;
            long x_v = x - Math.min(dp[0][v], dp[1][v] + w);
            dp[1][root] = Math.min(dp[1][root], x_v + dp[1][v]);
        }
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        edges = new ArrayList[n];
        for (int i = 0; i<n; i++) edges[i] = new ArrayList<>();
        int e = n - 1;
        while (e-- > 0) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }

        hasMachine = new boolean[n];
        for (int i = 0; i<k; i++) {
            int ii = in.nextInt();
            hasMachine[ii] = true;
        }

        visited = new boolean[n];
        dp = new long[2][n];

        dfs(0, -1);

        long ans = Math.min(dp[0][0], dp[1][0]);
        out.println(ans);

    }


    private static class Edge {
        public int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}
