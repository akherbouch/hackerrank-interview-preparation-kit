package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MinimumAbsoluteDifferenceInAnArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = in.nextInt();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<n - 1; i++) {
            final int abs = Math.abs(arr[i] - arr[i+1]);
            min = Math.min(abs, min);
        }
        out.println(min);
    }
}
