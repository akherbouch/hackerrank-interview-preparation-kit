package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class CastleOnTheGrid {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine());
        boolean[][] isOpen = new boolean[n][n];
        for (int i = 0; i<n; i++) {
            String line = in.nextLine();
            for (int j = 0; j<n; j++) {
                isOpen[i][j] = line.charAt(j) == '.';
            }
        }
        String[] xxyy = in.nextLine().split(" ");
        int sx = Integer.parseInt(xxyy[0]);
        int sy = Integer.parseInt(xxyy[1]);
        int gx = Integer.parseInt(xxyy[2]);
        int gy = Integer.parseInt(xxyy[3]);



        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> levels = new HashMap<>();
        queue.add(sx * n + sy);
        levels.put(sx * n + sy, 0);
        int ans = 0;
        outer : while (!queue.isEmpty()) {
            final int a = queue.poll();
            final int level = levels.get(a);
            final int x = a / n;
            final int y = a % n;
            for (int d = 0; d<4; d++) {
                int j = 0;
                while (++j < n) {
                    int xx = x + j*dx[d];
                    int yy = y + j*dy[d];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= n) break;
                    if (!isOpen[xx][yy]) break;
                    final int aa = xx * n + yy;
                    if(levels.containsKey(aa)) break;
                    ans = level + 1;
                    if (xx == gx && yy == gy) break outer;
                    levels.put(aa, level + 1);
                    queue.add(aa);
                }
            }
        }


        out.println(ans);




    }
}
