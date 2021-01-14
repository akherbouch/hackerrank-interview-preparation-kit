package com.aybx.hk.ipk;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class RecursiveDigitSum {


    public long digitSum(long a) {
        if (a == 0) return 0;
        return a % 10 + digitSum(a/10);
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String[] nk = in.nextLine().split(" ");
        String[] nd = nk[0].split("");
        int k = Integer.parseInt(nk[1]);
        long n = 0;
        for (String d : nd) n += Integer.parseInt(d);
        long ans = n * k ;
        while (ans > 9) {
            ans = digitSum(ans);
        }
        out.println(ans);
    }

/*    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String[] nk = in.nextLine().split(" ");
        String[] nd = nk[0].split("");
        int k = Integer.parseInt(nk[1]);
        int ans = 0;
        for (String d : nd) {
            int n = Integer.parseInt(d);
            ans = (ans + n*k) % 9;
        }
        if (ans == 0) ans = 9;
        out.println(ans);
    }*/


}
