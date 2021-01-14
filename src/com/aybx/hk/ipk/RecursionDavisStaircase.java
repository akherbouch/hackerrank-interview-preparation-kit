package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class RecursionDavisStaircase {

    private static final long MOD = 10_000_000_007L;


    private static long[] memo = new long[37];
    private static long stepPerms(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (memo[n] != 0) return memo[n];
        long res = stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);
        memo[n] = res % MOD;
        return res % MOD;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int tt = in.nextInt();
        while (tt-- > 0) {
            int n = in.nextInt();
            long ans = stepPerms(n);
            out.println(ans);
        }
    }
}
