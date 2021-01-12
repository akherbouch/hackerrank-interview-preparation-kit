package com.aybx.hk.ipk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

public class BalancedForest {

    ArrayList<Integer>[] adj;
    long[] sum;
    int[] values;
    HashSet<Long> notParents;
    HashSet<Long> parents;
    long ans;

    private void dfsForSum(int parent, int node) {
        long x = values[node];
        for (int a : adj[node]) {
            if (a == parent) continue;
            dfsForSum(node, a);
            x += sum[a];
        }
        sum[node] = x;
    }

    private void dfsForMin(int parent, int node) {

        // case 1 : there only two and node subtree one of them
        if (sum[0] % 2 == 0 && sum[node] == (sum[0]/2)) ans = Math.min(ans, sum[0]/2);

        // case 2 : node subtree is one of the biggest
        long mn = 3*sum[node] - sum[0];
        if (mn >= 0 && (notParents.contains(sum[node])
                    ||  notParents.contains(sum[0] - 2*sum[node])
                    ||  parents.contains(sum[0] - sum[node]) )
        ) ans = Math.min(ans, mn);


        // case 3 : node subtree is the smallest
        mn = (sum[0]-sum[node])/2 - sum[node];
        if ((sum[0] - sum[node]) % 2 == 0) {
            if (mn >= 0 && (notParents.contains((sum[0]-sum[node]) / 2 )
                        || parents.contains((sum[0] + sum[node]) / 2)))
                ans = Math.min(ans, mn);
        }

        parents.add(sum[node]);
        for (int a : adj[node]) {
            if (a == parent) continue;
            dfsForMin(node, a);
        }
        parents.remove(sum[node]);
        notParents.add(sum[node]);
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int tt = in.nextInt();
        while (tt-- > 0) {
            int n = in.nextInt();
            values = new int[n];
            sum = new long[n];
            adj = new ArrayList[n];
            for (int i = 0; i<n; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i<n; i++) values[i] = in.nextInt();
            for (int i = 0; i<n-1; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            dfsForSum(-1, 0);
            notParents = new HashSet<>();
            parents = new HashSet<>();
            ans = sum[0];
            dfsForMin(-1, 0);
            ans = ans != sum[0] ? ans : -1;
            out.println(ans);
        }
    }
}
