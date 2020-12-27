package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class CommonChild {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        //int ans = rec(s1, s2, 0, 0);

        int n = s1.length();
        int[][] dp = new int[5000 + 1][5000 + 1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }



        out.println(dp[0][0]);

    }
}
