package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class AlternatingCharacters {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = Integer.parseInt(in.nextLine());
        while (q-- > 0) {
            String s = in.nextLine();
            int ans = 0;
            char cur = s.charAt(0);
            int i = 1;
            while (i < s.length()) {
                if (cur == s.charAt(i)) ans++;
                else cur = s.charAt(i);
                i++;
            }
            out.println(ans);
        }
    }
}
