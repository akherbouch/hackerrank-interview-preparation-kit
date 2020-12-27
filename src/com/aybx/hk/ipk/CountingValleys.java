package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;



public class CountingValleys {

    public static int countingValleys(int n, String path) {
        int acc = 0;
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(path.charAt(i) == 'U') acc++;
            else acc--;
            if(acc == -1 && prev == 0) ans++;
            prev = acc;
        }
        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        out.println(countingValleys(n, s));
    }
}
