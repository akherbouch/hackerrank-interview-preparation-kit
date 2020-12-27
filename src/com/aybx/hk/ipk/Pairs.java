package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Pairs {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int low = 0, high = 1;
        int ans = 0;
        while (low < n && high < n) {
            int dt = arr[high] - arr[low];
            if(dt == k) {
                ans++;
                low++;
            } else if (dt < k) high++;
            else low++;
        }
        System.out.println(ans);
    }
}
