package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class MinimumTimeRequired {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int g = in.nextInt();
        int[] m = new int[n];
        int max = 0;
        for(int i = 0; i<n; i++) {
            m[i] = in.nextInt();
            max = Math.max(max, m[i]);
        }
        long low = 0;
        long high = (long) g/m.length*max + max;
        long ans = 0,mid,tmp;
        while (low <= high) {
            mid = (low + high) / 2L;
            tmp = 0L;
            for(int i = 0; i<n; i++) tmp += mid/m[i];
            if (tmp >= g) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        out.println(ans);
    }
}
