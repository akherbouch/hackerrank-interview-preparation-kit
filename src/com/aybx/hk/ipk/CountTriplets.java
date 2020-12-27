package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class CountTriplets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        final int n = in.nextInt();
        final int r = in.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = in.nextInt();
        Map<Integer, Long> occurrences = new HashMap<>();
        Map<Integer, Long> leftPairsPossibilities = new HashMap<>();
        long ans = 0L;
        for (int i = 0; i<n; i++) {
            if(arr[i] % r == 0) {
                if(arr[i] >= r*r) {
                    final long b = leftPairsPossibilities.getOrDefault(arr[i]/r, 0L);
                    ans += b;
                }

                if(arr[i] >= r) {
                    final long a = occurrences.getOrDefault(arr[i]/r, 0L);
                    final long b = leftPairsPossibilities.getOrDefault(arr[i], 0L);
                    leftPairsPossibilities.put(arr[i], b + a);
                }
            }
            final long oldValue = occurrences.getOrDefault(arr[i], 0L);
            occurrences.put(arr[i], oldValue + 1L);
        }
        out.println(ans);
    }
}
