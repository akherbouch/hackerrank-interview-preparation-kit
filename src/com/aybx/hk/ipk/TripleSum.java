package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TreeSet;

public class TripleSum {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int aa = in.nextInt();
        int bb = in.nextInt();
        int cc = in.nextInt();

        TreeSet<Integer> seta = new TreeSet<>();
        TreeSet<Integer> setb = new TreeSet<>();
        TreeSet<Integer> setc = new TreeSet<>();

        for(int i = 0; i<aa; i++) seta.add(in.nextInt());
        for(int i = 0; i<bb; i++) setb.add(in.nextInt());
        for(int i = 0; i<cc; i++) setc.add(in.nextInt());

        int[] a = seta.stream().mapToInt(Integer::intValue).toArray();
        int[] b = setb.stream().mapToInt(Integer::intValue).toArray();
        int[] c = setc.stream().mapToInt(Integer::intValue).toArray();

        long ans = 0;
        for (int i = 0; i<b.length; i++) {
            int pp = Arrays.binarySearch(a, b[i]);
            pp = Math.abs(pp+1);
            int rr = Arrays.binarySearch(c, b[i]);
            rr = Math.abs(rr+1);
            if(pp > 0 && rr > 0) ans += (long) pp * rr;
        }

        out.println(ans);


    }

}
