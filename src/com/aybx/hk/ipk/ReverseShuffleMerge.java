package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class ReverseShuffleMerge {

    private int digi(String s, int index) {
        return s.charAt(index) - 'a';
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int n = s.length();
        int[] needed = new int[26];
        for (char c : s.toCharArray()) needed[c - 'a']++;
        for (int i = 0; i<26; i++) needed[i] = needed[i] / 2;
        int[] a = new int[n/2];
        int LastPickedIndex = n;
        for (int i = 0; i < n/2; i++) {
            // Checking if we can set the char (from a to z) on the position i on of A
            abc: for (int ci = 0; ci<26; ci++) {
                a[i] = ci;
                // we pick from right to left
                int p = LastPickedIndex - 1;
                while (p >= 0 && a[i] != digi(s, p)) p--;
                if (p < 0) continue;

                // Count the freq of the remaining chars
                int[] have = new int[26];
                for(int j = 0; j < p; j++) have[digi(s, j)]++;

                // Checking if we have all what we need
                needed[ci]--;
                for(int cj = 0; cj < 26; cj++) {
                    if(needed[cj] < 0 || needed[cj] > have[cj]) {
                        needed[ci]++;
                        continue abc;
                    }
                }

                LastPickedIndex = p;
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int ci : a) ans.append((char) (ci + 'a'));
        out.println(ans);
    }


}
