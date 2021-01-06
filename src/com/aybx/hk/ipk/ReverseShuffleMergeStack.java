package com.aybx.hk.ipk;

import java.io.PrintWriter;
import java.sql.Struct;
import java.util.Scanner;
import java.util.Stack;

public class ReverseShuffleMergeStack {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int[] remAFreq = new int[26];
        int[] remShuffledFreq = new int[26];
        for (char c : s.toCharArray()) remAFreq[c - 'a']++;
        for (int i = 0; i<26; i++) remAFreq[i] = remShuffledFreq[i] = remAFreq[i] / 2;

        int i = s.length();
        Stack<Character> stack = new Stack<>();
        while (i-- > 0) {
            char c = s.charAt(i);
            if (remAFreq[c - 'a'] == 0) {
                remShuffledFreq[c - 'a']--;
                continue;
            }
            remAFreq[c - 'a']--;
            while (!stack.isEmpty() && c < stack.peek() && remShuffledFreq[stack.peek() - 'a'] > 0) {
                remAFreq[stack.peek() - 'a']++;
                remShuffledFreq[stack.pop() - 'a']--;
            }
            stack.add(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) ans.append(stack.pop());
        out.println(ans.reverse());
    }
}
