package com.aybx.hk.ipk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.io.PrintWriter;

public class SherlockAndTheValidString {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int[] abc = new int[26];
        for (char c : s.toCharArray()) abc[c - 'a']++;

        boolean ans = false;

        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (abc[i] > 0)
                set2.add(abc[i]);
        }
        if (set2.size() == 1) ans = true;

        for (int i = 0; i < 26 && !ans; i++) {
            if (abc[i] == 0) continue;
            abc[i]--;

            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < 26; j++)
                if (abc[j] > 0)
                    set.add(abc[j]);

            if (set.size() == 1) ans = true;

            abc[i]++;
        }

        if (ans) out.println("YES");
        else out.println("NO");

    }
}
