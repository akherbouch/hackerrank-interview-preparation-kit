package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class Candies {

    /*    static long candies(int n, int[] arr) {
        long[] can = new long[n];
        can[0] = arr[0] <= arr[1] ? 1 : 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1] && arr[i] <= arr[i - 1])
                can[i] = 1;
            else if (arr[i] > arr[i - 1] && arr[i] <= arr[i + 1])
                can[i] = can[i - 1] + 1;
            else
                can[i] = 0;
        }
        can[n - 1] = arr[n - 1] <= arr[n - 2] ? 1 : (can[n - 2] + 1);
        for (int i = n - 2; i >= 0; i--) {
            if (can[i] != 0)
                continue;
            if (i == 0)
                can[i] = can[i + 1] + 1;
            if (arr[i - 1] >= arr[i])
                can[i] = can[i + 1] + 1;
            else
                can[i] = Math.max(can[i - 1], can[i + 1]) + 1;
        }
        long s = 0;
        for (int i = 0; i < n; i++)
            s += can[i];
        return s;
    }*/

    static long candies(int n, int[] arr) {
        long ans = 0;
        long[] can = new long[n];

        for(int i = 0; i<n; i++) can[i] = 1;

        for(int i = 1; i<n; i++) {
            if(arr[i] > arr[i-1])
                can[i] = can[i-1] + 1;
        }

        for(int i = n-2; i>=0; i--) {
            if(arr[i] > arr[i+1] && can[i] <= can[i+1])
                can[i] = can[i+1] + 1;
        }

        while (n-- > 0) ans += can[n];

        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        out.println(candies(n, arr));
    }
}
