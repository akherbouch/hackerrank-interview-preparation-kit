package com.aybx.hk.ipk;

import java.io.PrintWriter;
import java.util.Scanner;

public class MakingCandiesGreedy {

    static long minimumPasses(long m, long w, long p, long n) {
        long passes = 0;
        long candy = 0;
        long run = Long.MAX_VALUE;
        long step;
        while (candy < n) {
            step = (m > Long.MAX_VALUE / w) ? 0 : (p - candy) / (m * w);
            if (step <= 0)  {
                // Buy as much as you can
                long mw = candy / p;
                if (m >= w + mw) w += mw;
                else if (w >= m + mw) m += mw;
                else  {
                    long total = m + w + mw;
                    m = total / 2;
                    w = total - m;
                }
                candy %= p;
                step = 1;
            }
            passes += step;
            if (step * m > Long.MAX_VALUE / w) candy = Long.MAX_VALUE;
            else {
                candy += step * m * w;
                run = Math.min(run, (long)(passes + Math.ceil((n - candy) / (m * w * 1.0))));
            }
        }
        return Math.min(passes, run);
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String[] mwpn = in.nextLine().split(" ");
        long m = Long.parseLong(mwpn[0]);
        long w = Long.parseLong(mwpn[1]);
        long p = Long.parseLong(mwpn[2]);
        long n = Long.parseLong(mwpn[3]);
        long res = minimumPasses(m, w, p, n);
        out.println(res);
    }
}
