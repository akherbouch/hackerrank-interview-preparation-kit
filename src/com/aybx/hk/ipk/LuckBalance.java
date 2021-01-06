package com.aybx.hk.ipk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class LuckBalance {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> imp = new ArrayList<>();
        int ans = 0;
        int a = n - k;
        for (int i = 0; i<n; i++) {
            int l = in.nextInt();
            int t = in.nextInt();
            if (t == 1) imp.add(l);
            else a--;
            ans += l;
        }
        Collections.sort(imp);
        while (a-- > 0) {
            ans -= 2 * imp.get(a);
        }
        out.println(ans);
    }
}
