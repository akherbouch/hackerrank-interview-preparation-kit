package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class RecursionFibonacciNumbers {

    // n <= 30 so we don't have to memorize
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int ans = fibonacci(n);
        out.print(ans);
    }
}
