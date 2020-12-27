package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class ArraysLeftRotation {
    static int[] rotLeft(int[] a, int d) {
        int[] ans = new int[a.length];
        for(int i=0; i<a.length; i++) {
            int ii = (i+d)%a.length;
            ans[i] = a[ii];
        }
        return ans;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i<n; i++) {
            a[i] = in.nextInt();
        }

        int[] result = rotLeft(a, d);

        StringBuilder pp = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            pp.append(result[i]);
            if (i < result.length - 1) pp.append(" ");
        }

        out.println(pp.toString());

    }
}
