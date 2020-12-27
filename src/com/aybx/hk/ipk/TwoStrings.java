package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        int[] abc = new int[26];
        for (char c : s1.toCharArray())
            abc[c - 'a']++;
        for (char c : s2.toCharArray()) {
            if (abc[c - 'a'] > 0) return "YES";
        }
        return "NO";
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int p = Integer.parseInt(in.nextLine());
        while (p-- > 0) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            out.println(twoStrings(s1, s2));
        }
    }
}