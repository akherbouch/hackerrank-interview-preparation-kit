package com.aybx.hk.ipk;

import java.util.*;
import java.io.PrintWriter;

public class SherlockAndAnagrams {

    static class Word {
        String str;
        int[] abc;
        Word(String str) {
            this.str = str;
            this.abc = new int[26];
            for (char c : str.toCharArray()) abc[c - 'a']++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Arrays.equals(abc, word.abc);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(abc);
        }
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = Integer.parseInt(in.nextLine());
        for (int qq = 0; qq < q; qq++) {
            String str = in.nextLine();
            Map<Word, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    String sub = str.substring(j, i + 1);
                    Word word = new Word(sub);
                    int cc = map.getOrDefault(word, 0);
                    if(cc > 0) ans += cc;
                    map.put(word, cc + 1);
                }
            }
            out.println(ans);
        }

    }
}
