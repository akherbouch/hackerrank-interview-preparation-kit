package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class MinimumSwaps2 {


    static int minimumSwaps(int[] arr) {
        int ans = 0;
        for(int i = 0; i<arr.length; i++) {
            while(arr[i] != i+1) {
                ans++;
                int ii = arr[i] - 1;
                int tmp = arr[i];
                arr[i] = arr[ii];
                arr[ii] = tmp;
            }
        }
        return ans;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = in.nextInt();
        System.out.println(minimumSwaps(arr));
    }
}
