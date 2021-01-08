package com.aybx.hk.ipk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class RoadsAndLibraries {

    ArrayList<Integer>[] roads;
    boolean[] visited;

    // Get all connected cities
    private int dfs(int city) {
        int res = 1;
        visited[city] = true;
        for (int c : roads[city]) {
            if (!visited[c]) {
                res += dfs(c);
            }
        }
        return res;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int cLib = in.nextInt();
            int cRoad = in.nextInt();
            roads = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                roads[i] = new ArrayList<>();

            while (m-- > 0) {
                int u = in.nextInt();
                int v = in.nextInt();
                roads[u].add(v);
                roads[v].add(u);
            }
            if (cRoad >= cLib) {
                out.println((long) n * cLib);
                continue;
            }
            long ans = 0;

            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                ans += cLib;
                ans += (long) (dfs(i) - 1) * cRoad;
            }

            out.println(ans);
        }
    }
}
