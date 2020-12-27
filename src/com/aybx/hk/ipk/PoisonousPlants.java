package com.aybx.hk.ipk;

import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class PoisonousPlants {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++) a[i] = in.nextInt();


        int ans = 0;
        Stack<Integer> istk = new Stack<>();
        int[] days = new int[n];
        int i = 0;
        while (i < n) {
            int d = 0;
            while (!istk.isEmpty() && a[i] <= a[istk.peek()]) {
                final int ii = istk.pop();
                d = Math.max(d, days[ii]);
            }

            days[i] = istk.isEmpty() ? 0 : d + 1;
            ans = Math.max(ans, days[i]);
            istk.push(i++);
        }

        out.println(ans);
    }
}
