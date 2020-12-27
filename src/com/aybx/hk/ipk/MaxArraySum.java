package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class MaxArraySum {

/*    static int maxSubsetSum(int[] arr) {
        int[] maxSum = new int[arr.length];

        maxSum[0] = Math.max(arr[0], 0);
        maxSum[1] = Math.max(arr[1], maxSum[0]);

        for(int i = 2; i<arr.length; i++) {
            if(arr[i]<=0)
                maxSum[i] = maxSum[i-1] = Math.max(maxSum[i-2], maxSum[i-1]);
            else maxSum[i] = Math.max(arr[i]+maxSum[i-2], maxSum[i-1]);
        }

        return Math.max(maxSum[arr.length-2], maxSum[arr.length-1]);
    }*/

    static int maxSubsetSum(int[] arr) {
        int[] maxSum = new int[arr.length];

        maxSum[0] = arr[0];
        maxSum[1] = Math.max(arr[1], arr[0]);

        for(int i = 2; i<arr.length; i++) {
            maxSum[i] = Math.max(arr[i]+maxSum[i-2], maxSum[i-1]);
            maxSum[i] = Math.max(arr[i], maxSum[i]);
        }

        return maxSum[arr.length-1];
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = in.nextInt();

        out.println(maxSubsetSum(arr));
    }
}
