package com.aybx.hk.ipk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;




public class HashTablesRansomNote {

    static boolean checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> hashtable = new HashMap<>();
        int tmp = 0;
        for (int i = 0; i<magazine.length; i++) {
            tmp = hashtable.getOrDefault(magazine[i], 0);
            hashtable.put(magazine[i], tmp + 1);
        }
        for (int i = 0; i<note.length; i++) {
            tmp = hashtable.getOrDefault(note[i], 0);
            if (tmp == 0) return false;
            hashtable.put(note[i], tmp - 1);
        }
        return true;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String[] mn = in.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] magazine = in.nextLine().split(" ");
        String[] note = in.nextLine().split(" ");
        if(checkMagazine(magazine, note))
            out.println("Yes");
        else out.println("No");
    }
}
