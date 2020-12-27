package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class SpecialStringAgain {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine());
        char[] abc = in.nextLine().toCharArray();
        long ans = 0;
        int i = 0;
        while(i < n) {
            int rep = 1;
            while (i + rep < n && abc[i] == abc[i + rep]) rep++;
            ans += (rep+1)*rep/2;

            if (rep > 1) {
                i += rep;
                continue;
            }

            int mirror = 1;
            while (i + mirror < n && i - mirror >= 0 && abc[i-mirror] == abc[i+mirror]
                    && abc[i-1] == abc[i-mirror])
                mirror++;

            ans += mirror - 1;

            i++;
        }
        out.println(ans);
    }
}
