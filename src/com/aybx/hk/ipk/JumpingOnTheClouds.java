package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        int ans = 0;
        int i = 0;
        while (i < c.length-2) {
            if(c[i+2] == 1) i++;
            else i += 2;
            ans++;
        }
        if (i < c.length - 1) ans++;
        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] c = new int[n];
        for(int i = 0; i < n; i++) c[i] = in.nextInt();
        out.println(jumpingOnClouds(c));
    }
}
