package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class DFSConnectedCellInAGrid {

    int[][] grid;
    boolean[][] visited;
    int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    private int dfs(int i, int j) {
        if (grid[i][j] == 0) return 0;
        int res = 1;
        visited[i][j] = true;
        for (int d = 0; d<8; d++) {
            int ii = i + di[d];
            int jj = j + dj[d];
            if (ii < 0 || jj < 0 || ii >= grid.length || jj >= grid[0].length) continue;
            if (visited[ii][jj]) continue;
            res += dfs(ii, jj);
        }
        return res;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                grid[i][j] = in.nextInt();
                visited[i][j] = false;
            }
        }
        int ans = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (visited[i][j]) continue;
                ans = Math.max(ans, dfs(i, j));
            }
        }
        out.println(ans);

    }
}
