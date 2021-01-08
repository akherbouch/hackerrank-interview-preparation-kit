package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class FindTheNearestClone {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        while (m-- > 0) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj[v].add(u);
            adj[u].add(v);
        }
        int[] colors = new int[n];
        for (int i = 0; i<n; i++) colors[i] = in.nextInt();
        int target = in.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i<n; i++) {
            if (colors[i] == target) {
                boolean[] visited = new boolean[n];
                Map<Integer, Integer> levels = new HashMap<>();
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    int level = levels.getOrDefault(cur, 0);
                    visited[cur] = true;
                    for (int a : adj[cur]) {
                        if(visited[a]) continue;
                        queue.add(a);
                        if (colors[a] == target)
                            ans = Math.min(ans, level + 1);
                        levels.put(a, level + 1);
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) out.println(-1);
        else out.println(ans);

    }
}
