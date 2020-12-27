package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class SortingBubbleSort {

    static void countSwaps(int[] a) {
        int swaps = 0;
        boolean run = true;
        while (run) {
            run = false;
            for(int i=1; i<a.length; i++) {
                if(a[i-1] > a[i]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    run = true;
                    swaps++;
                }
            }
        }

        System.out.println("Array is sorted in "+swaps+" swaps.\n" +
                "First Element: "+a[0]+"\n" +
                "Last Element: "+a[a.length-1]);

    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        countSwaps(a);

    }
}
