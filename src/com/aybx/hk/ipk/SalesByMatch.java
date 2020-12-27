package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class SalesByMatch {

    static int[] colors = new int[201];
    static int sockMerchant(int n, int[] ar) {
        for(int i=0; i<n; i++) {
            colors[ar[i]]++;
        }
        int ans = 0;

        for(int i=0; i<201; i++) {
            ans += colors[i]/2;
        }

        return ans;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        out.println(sockMerchant(n, arr));
    }
}
