package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class BalancedBrackets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i<n; i++) {
            String s = in.nextLine();
            boolean isBalanced = true;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '{') stack.push('}');
                else if (c == '(') stack.push(')');
                else if (c == '[') stack.push(']');
                else if (stack.isEmpty() || c != stack.pop()) {
                    isBalanced = false;
                    break;
                }
            }
            if (isBalanced && stack.isEmpty()) out.println("YES");
            else out.println("NO");
        }
    }
}
