package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class FlippingBits {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int tt = in.nextInt();
        while (tt-- > 0) {
            long n = in.nextLong();
            long ans = 0xffffffffL - n;
            out.println(ans);
        }
    }

 /*   public void solve(int testNumber, Scanner in, PrintWriter out) {
        int tt = in.nextInt();
        while (tt-- > 0) {
            long n = in.nextLong();
            long ans = 0;
            for (int i = 0; i<32; i++) {
                long a = n >> i & 1L;
                if (a == 0) ans += 1L << i;
            }
            out.println(ans);
        }
    }*/
}
