package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int ans = 0;
        for(int p = q.length; p > 1; p--) {
            int i = p - 1;
            if(q[i] == p) continue;
            if(q[i-1] == p) {
                ans+=1;
                int tmp = q[i-1];
                q[i-1] = q[i];
                q[i] = tmp;
            }
            else if(q[i-2] == p) {
                ans+=2;
                int tmp = q[i-2];
                q[i-2] = q[i-1];
                q[i-1] = q[i];
                q[i] = tmp;
            }
            else {
                System.out.println("Too chaotic");
                return;
            }
        }

        System.out.println(ans);
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            minimumBribes(arr);
        }
    }
}
