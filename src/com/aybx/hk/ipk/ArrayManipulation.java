package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        for(int i=1; i<n; i++) {
            arr[i] = 0;
        }
        for(int i=0; i<queries.length; i++) {
            arr[queries[i][0]-1] += queries[i][2];
            if(queries[i][1] < n)
                arr[queries[i][1]] -= queries[i][2];
        }
        long max = arr[0];
        for(int i=1; i<n; i++) {
            arr[i] += arr[i-1];
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] qq = new int[m][3];
        for(int i = 0; i<m; i++) {
            qq[i][0] = in.nextInt();
            qq[i][1] = in.nextInt();
            qq[i][2] = in.nextInt();
        }
        System.out.println(arrayManipulation(n, qq));
    }
}
