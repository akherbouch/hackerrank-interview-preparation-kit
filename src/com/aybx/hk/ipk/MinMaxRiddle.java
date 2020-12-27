package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class MinMaxRiddle {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++) a[i] = in.nextInt();
        int[] ans = new int[n];
        Map<Integer, Integer> range = new HashMap<>();

        int i = 0;
        int count = 0;// you can use i, just to make it easy to understand,
        Stack<Integer> indicesStk = new Stack<>();
        while (i < n) {
            if (indicesStk.isEmpty() || a[i] > a[indicesStk.peek()]) {
                indicesStk.push(i);
                count++;
                i++;
                continue;
            }
            while (!indicesStk.isEmpty() && a[indicesStk.peek()] >= a[i]) {
                int ii = indicesStk.pop();
                int mx = indicesStk.isEmpty() ? count : count - indicesStk.peek() - 1;
                mx = Math.max(mx, range.getOrDefault(a[ii], 0));
                range.put(a[ii], mx);
            }
        }
        while (!indicesStk.isEmpty()) {
            int ii = indicesStk.pop();
            int mx = indicesStk.isEmpty() ? count : count - indicesStk.peek() - 1;
            mx = Math.max(mx, range.getOrDefault(a[ii], 0));
            range.put(a[ii], mx);
        }

        Arrays.sort(a);
        int ii = n-1;
        for (int w = 1; w <= n; w++) {
            while (range.get(a[ii]) < w) ii--;
            ans[w-1] = a[ii];
        }


        for (int k = 0; k<n; k++) out.print(ans[k] + " ");
        out.println();
    }
}
