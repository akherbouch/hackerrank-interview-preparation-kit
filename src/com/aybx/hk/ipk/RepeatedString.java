package com.aybx.hk.ipk;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        int l = s.length();
        int[] as = new int[l];
        if (s.charAt(0) == 'a') as[0] = 1; else as[0] = 0;
        for (int i = 1; i < l; i++) {
            as[i] = as[i-1];
            if (s.charAt(i) == 'a') as[i]++;
        }
        return n/s.length()*as[l-1] + ( n % l != 0 ? as[(int) (n % l - 1)] : 0);
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        long n = in.nextLong();
        out.println(repeatedString(s, n));
    }
}
