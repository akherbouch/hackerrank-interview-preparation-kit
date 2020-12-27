package com.aybx.hk.ipk;

import java.io.PrintWriter;
import java.util.*;

public class MakingCandiesBfs {

    static class State {
        public long candies, w, m;
        public State(long candies, long w, long m) {
            this.candies = candies;
            this.w = w;
            this.m = m;
        }

        public void buy(long q) {
            long mn = Math.min(w, m);
            long mx = w + m - mn;
            long d = mx - mn;
            long r = q;
            while (d-- > 0 && r-- > 0) mn++;
            if (r > 0) {
                mn = mn +  r / 2;
                mx = mx + r / 2 + r % 2;
            }
            if(w > m) {
                w = mx;
                m = mn;
            } else {
                w = mn;
                m = mx;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return candies == state.candies &&
                    w == state.w &&
                    m == state.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(candies, w, m);
        }
    }

    static long minimumPasses(long m, long w, long p, long n) {
        Queue<State> queue = new LinkedList<>();
        HashMap<State, Long> map = new HashMap<>();
        State st = new State(0, w, m);
        queue.add(st);
        map.put(st, 0L);
        long ans = 0;
        while (!queue.isEmpty()) {
            State curState = queue.poll();
            Long curStep = map.get(curState);
            long curCandies = curState.candies + curState.w*curState.m;
            if (curCandies >= n) return curStep + 1;
            if (curCandies >= p) {
                long q = curCandies / p;
                long r = curCandies % p;
                State ns = new State(r, curState.w, curState.m);
                ns.buy(q);
                if(!map.containsKey(ns)) {
                    queue.add(ns);
                    map.put(ns, curStep + 1);
                }
            }
            State ns = new State(curCandies, curState.w, curState.m);
            if(!map.containsKey(ns)) {
                queue.add(ns);
                map.put(ns, curStep + 1);
            }
        }
        return ans;
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
