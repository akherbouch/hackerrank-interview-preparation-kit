package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class FraudulentActivityNotifications {

//    // O(n*d*logd)
//    static int activityNotifications(int[] expenditure, int d) {
//        int ans = 0;
//        for(int i = d; i<expenditure.length; i++) {
//            int[] arr = Arrays.copyOfRange(expenditure, i-d, i);
//            Arrays.sort(arr);
//            int limit = arr[d/2] + arr[d/2 + d%2 - 1];
//            if(expenditure[i] >= limit) ans++;
//        }
//        return ans;
//    }
    
//    int median2(int D) {
//        int p = 0;
//        for (int i = 0; i < 201; i++) {
//            p += counter[i];
//            if (p * 2 > d) {
//                return 2 * i;
//            } else if (p * 2 == d) {
//                for (int j = i + 1; ; j++) {
//                    if (counter[j]>0) {
//                        return i + j;
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    // O(200*n)
    static int activityNotifications(int[] expenditure, int d) {
        int ans = 0;
        int[] counter = new int[201];
        for(int i=0; i<d; i++) counter[expenditure[i]]++;

        for(int i = d; i<expenditure.length; i++) {
            // get Median
            int limit = 0;
            int md1 = d/2 + 1;
            int md2 = d/2 + d%2;

            for(int j=0; j<201; j++) {
                md1 -= counter[j];
                if(md1 <= 0) {
                    limit += j;
                    break;
                }
            }
            for(int j=0; j<201; j++) {
                md2 -= counter[j];
                if(md2 <= 0) {
                    limit += j;
                    break;
                }
            }

            if(expenditure[i] >= limit) ans++;
            counter[expenditure[i]]++;
            counter[expenditure[i-d]]--;
        }
        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] exp = new int[n];
        for(int i=0; i<n; i++) {
            exp[i] = in.nextInt();
        }
        out.println(activityNotifications(exp, d));
    }
}
