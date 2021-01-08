package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class Matrix {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        Edge[] edges = new Edge[n-1];
        int e = 0;
        while (e < n - 1) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edges[e++] = new Matrix.Edge(u, v, w);
        }

        boolean[] hasMachine = new boolean[n];
        for (int i = 0; i<k; i++) {
            int ii = in.nextInt();
            hasMachine[ii] = true;
        }

        DisjointSet ds = new DisjointSet(n, hasMachine);
        Arrays.sort(edges, Comparator.comparingInt(o -> -o.w));

        long ans = 0;
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            if (ds.hasMachine(u) && ds.hasMachine(v)) {
                ans += edge.w;
                continue;
            }
            ds.union(v, u);
        }

        out.println(ans);



    }


    private static class Edge {
        public int u,v,w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }


    private static class DisjointSet {

        private final int[] parents;
        private final byte[] rank;
        private final boolean[] machine;

        public DisjointSet(int size, boolean[] hasMachine) {
            parents = new int[size];
            rank = new byte[size];
            machine = new boolean[size];
            for (int i = 0; i<size; i++) {
                parents[i] = i;
                rank[i] = 0;
                machine[i] = hasMachine[i];
            }
        }

        public int find(int v) {
            if (parents[v] == v) return v;
            while (parents[v] != v) {
                parents[v] = parents[parents[v]];
                v = parents[v];
            }
            return v;
        }

        public boolean hasMachine(int v) {
            int root = find(v);
            return machine[root];
        }

        public void union(int v, int u) {
            int rootV = find(v);
            int rootU = find(u);
            if (rootU == rootV) return;
            boolean m = machine[rootU] || machine[rootV];
            if (rank[rootU] > rank[rootV]) {
                parents[rootV] = rootU;
                machine[rootU] = m;
            } else if (rank[rootV] > rank[rootU]) {
                parents[rootU] = rootV;
                machine[rootV] = m;
            } else {
                parents[rootU] = rootV;
                machine[rootV] = m;
                rank[rootV]++;
            }
        }
    }
}
