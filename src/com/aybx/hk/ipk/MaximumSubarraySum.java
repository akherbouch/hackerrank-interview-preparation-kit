package com.aybx.hk.ipk;

import kotlin.Pair;

import java.util.*;
import java.io.PrintWriter;


/*
1 2 -6 4 5 -5 7
1 3 -3 1 6 1 8
 */


public class MaximumSubarraySum {



    static long maximumSum(long[] a, long m) {
        long sum = 0;
        TreeSet<Long> set = new TreeSet<>();
        set.add(0L);
        long ans = 0L;
        for(int i = 0; i<a.length; i++) {
            sum = (sum + a[i]) % m;
            ans = Math.max(ans, sum);
            Long lower = set.higher(sum); // the least element higher than sum and its index is lower than i
            if(lower != null)
                ans = Math.max(ans, (sum - lower + m) % m);
            set.add(sum);
        }
        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while (q-- > 0) {
            String[] nm = in.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            long m = Long.parseLong(nm[1]);
            long[] a = new long[n];
            String[] aItems = in.nextLine().split(" ");
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for(int i = 0; i<n; i++) a[i] = Long.parseLong(aItems[i]);
            long result = maximumSum(a, m);
            out.println(result);
        }
    }
}
