package com.aybx.hk.ipk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TimeComplexityPrimality {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        // Preprocessing
        final int SQRT = 44722 + 1;
        boolean[] isPrime = new boolean[SQRT];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i<SQRT; i++) isPrime[i] = true;
        for (int i = 2; i<SQRT; i++) {
            if (!isPrime[i]) continue;
            primes.add(i);
            for (int j = 2; i * j <SQRT; j++) {
                isPrime[i * j] = false;
            }
        }

        int tt = in.nextInt();
        while (tt-- > 0) {
            int n = in.nextInt();
            String ans = "Prime";
            if (n < SQRT) ans = isPrime[n] ? "Prime" : "Not prime";
            else for (int p : primes) {
                if (n % p == 0) {
                    ans = "Not prime";
                    break;
                }
            }
            out.println(ans);
        }
    }
}
