package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;


//https://math.stackexchange.com/questions/3540243/whats-the-number-of-decibinary-numbers-that-evaluate-to-given-decimal-number/3545775#3545775
public class DecibinaryNumbers {

    static int dmax = 1000;
    static long[][] dp = new long[dmax+1][21];
    static long[] acc = new long[dmax+1];

    static void preprocessing() {
        acc[0] = 1;
        for(int i = 1; i<dmax; i++) {
            acc[i] = repCounts(i, 20);
            acc[i] += acc[i-1];
        }
    }


    static long repCounts(int n, int m) {

        if(n == 0) return 1;
        if(m == 0) return 0;

        if(n == 1) return 1;
        if(m == 1) {
            if(n - 9 > 0) return 0;
            else return 1;
        }

        if(dp[n][m] != 0) return dp[n][m];

        long ans = 0;
        int p = Math.min(n >> (m-1), 9);
        for(int i=0; i<=p; i++) {
            ans += repCounts(n - i*(1 << (m-1)), m - 1);
        }
        dp[n][m] = ans;
        return ans;
    }

    static void printX(long ro, int n, int m, StringBuilder str) {
        if(m == 0) return;
        int val = 0;
        for (int i = 0; i <= 9; i++) {
            int nn = n - (1 << m-1) * i;
            if (nn >= 0) {
                val += repCounts(nn, m-1);
            }
            if (val >= ro) {
                str.append(i);
                printX(ro-val+repCounts(nn, m-1), nn, m-1, str);
                break;
            }
        }
    }

    static String decibinaryNumbers(long x) {

        if (x == 1) return "0";

        int lo = 0;
        int hi = dmax;

        int decimal = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (acc[mid] >= x) {
                decimal = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }


        long repOrder = x - acc[decimal - 1];
        int rep = 0;
        while (repCounts(decimal, rep) < repOrder) rep++;

        StringBuilder str = new StringBuilder();

        printX(repOrder, decimal, rep, str);

        return str.toString();
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        preprocessing();
        while(t-- > 0) {
            long x = in.nextLong();
            out.println(decibinaryNumbers(x));
        }
    }
}
