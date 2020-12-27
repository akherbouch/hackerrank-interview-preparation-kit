package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class ConnectedCellsInAGrid {

    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static boolean[][] visited = new boolean[10][10];
    static int dfs(int i, int j, int[][] matrix) {
        visited[i][j] = true;
        int ans = 1;
        for (int dir = 0; dir<8; dir++) {
            int ii = i + dx[dir];
            int jj = j + dy[dir];
            if (ii >= 0 && jj >= 0
                    && ii < matrix.length
                    && jj < matrix[0].length
                    && !visited[ii][jj]
                    && matrix[ii][jj] == 1)  {
                ans += dfs(ii, jj, matrix);
            }
        }
        return ans;
    }

    static void clear() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                visited[i][j] = false;
    }

    static int connectedCell(int[][] matrix) {
        int max = 0;
        for (int i = 0; i< matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) continue;
                clear();
                int tmp = dfs(i, j, matrix);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < m; j++)
                matrix[i][j] = Integer.parseInt(matrixRowItems[j]);
        }
        int result = connectedCell(matrix);
        out.println(result);
    }
}
