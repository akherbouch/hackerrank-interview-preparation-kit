package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Anagram {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = Integer.parseInt(in.nextLine());
        for (int qq = 0; qq<q; qq++) {
            String s = in.nextLine();
            if (s.length() % 2 == 1) {
                out.println(-1);
                continue;
            }
            int[] abc1 = new int[26];
            int[] abc2 = new int[26];
            for (int i = 0; i < s.length() / 2; i++) {
                abc1[s.charAt(i) - 'a']++;
                abc2[s.charAt(i + s.length()/2) - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                ans += Math.abs(abc1[i] - abc2[i]);
            }
            out.println(ans / 2);
        }
    }
}
