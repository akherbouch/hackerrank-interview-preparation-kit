package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MaxMin {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = in.nextInt();
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int cur = 0;
        int i = 0;
        while (i + k - 1 < n) {
            cur = arr[i + k - 1] - arr[i];
            ans = Math.min(ans, cur);
            i++;
        }
        out.println(ans);
    }
}

