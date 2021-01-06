package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class GreedyFlorist {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i<n; i++) c[i] = in.nextInt();
        Arrays.sort(c);
        int fa = 0;
        int i = n;
        int ans = 0;
        while (i-- > 0) {
            fa = (n - i - 1) / k  + 1;
            ans += fa*c[i];
        }
        out.print(ans);
    }
}
