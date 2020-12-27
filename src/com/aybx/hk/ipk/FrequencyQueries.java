package com.aybx.hk.ipk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class FrequencyQueries {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        Map<Integer, Integer> occurrences = new HashMap<>();
        Map<Integer, Integer> feqCounter = new HashMap<>();
        for (int i = 0; i<q; i++) {
            final int operation = in.nextInt();
            if (operation == 1) {
                final int x = in.nextInt();
                int oldFreq = occurrences.getOrDefault(x, 0);
                occurrences.put(x, oldFreq + 1);

                int fc1 = feqCounter.getOrDefault(oldFreq, 0);
                feqCounter.put(oldFreq, fc1 > 0 ? fc1 - 1 : 0);

                int fc2 = feqCounter.getOrDefault(oldFreq + 1, 0);
                feqCounter.put(oldFreq + 1, fc2 + 1);
            }
            else if (operation == 2) {
                final int y = in.nextInt();
                int oldFreq = occurrences.getOrDefault(y, 0);
                occurrences.put(y, oldFreq > 0 ? oldFreq - 1 : 0);

                int fc1 = feqCounter.getOrDefault(oldFreq, 0);
                feqCounter.put(oldFreq, fc1 > 0 ? fc1 - 1 : 0);

                int fc2 = feqCounter.getOrDefault(oldFreq - 1, 0);
                feqCounter.put(oldFreq - 1, fc2 + 1);
            }
            else if (operation == 3) {
                final int z = in.nextInt();
                int ans = feqCounter.getOrDefault(z, 0) > 0 ? 1:0;
                out.println(ans);
            }
        }
    }
}
