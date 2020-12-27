package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class StringsMakingAnagrams {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int[] abc1 = new int[26];
        int[] abc2 = new int[26];
        for(char c : s1.toCharArray()) abc1[c - 'a']++;
        for(char c : s2.toCharArray()) abc2[c - 'a']++;
        int ans = 0;
        for (int i = 0; i<26; i++) {
            ans += Math.abs(abc1[i] - abc2[i]);
        }
        out.println(ans);
    }
}
