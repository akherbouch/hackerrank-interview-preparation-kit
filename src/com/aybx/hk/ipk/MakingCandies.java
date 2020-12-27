package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class MakingCandies {
    

    static boolean check(long machines, long workers, long price, long target, long rounds) {
        // check for overflow
        if (machines != 0 && workers > Long.MAX_VALUE / machines) return true;

        long curCandies = 0;
        long remRounds = rounds; // remaining rounds
        while (true) {
            long curTarget = target - curCandies;
            long curResources = machines*workers;

            // check if we can achieve the target with the current resources and less rounds
            if (Math.ceil(1.0 * curTarget / curResources) <= remRounds) return true;
            // in case we cannot achieve the new target with our resources we should buy new one

            if(curCandies < price) { // ops we don't have enough candies to buy one
                long neededCandies = price - curCandies;
                // calc numbers of rounded we need to achieve the price
                long neededRounds = (long) Math.ceil(1.0 * neededCandies / curResources);
                if (neededRounds >= remRounds) return false;
                remRounds -= neededRounds;
                curCandies += neededRounds * curResources;

            }

            // To maximize the number of candies made, we must buy the resource we have less of
            if (machines > workers) workers++;
            else machines++;
            curCandies -= price;
        }
    }

    static long minimumPasses(long machines, long workers, long price, long target) {
        long low = 1L;
        long high = Long.MAX_VALUE  - 1;
        long mid;
        // we binary search on the answer with lowerbound
        while (low < high) {
            mid = (low + high) / 2L;
            if(check(machines, workers, price, target, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
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
