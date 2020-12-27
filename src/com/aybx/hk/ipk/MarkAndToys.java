package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int cur = 0;
        for(int i=0; i<prices.length; i++) {
            cur += prices[i];
            if(cur > k) return i;
        }
        return prices.length;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for(int i=0; i<n; i++) {
            prices[i] = in.nextInt();
        }
        out.println(maximumToys(prices, k));
    }
}
