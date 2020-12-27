package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class Abbreviation {

    static boolean ans = false;
    static boolean[][] memo = new boolean[1001][1001];

    static String abbreviation(String a, String b) {
        for(int i = 0; i<memo.length; i++) {
            for(int j= 0; j<memo[0].length; j++) {
                memo[i][j] = false;
            }
        }
        ans = false;
        rec(a, b , 0 ,0);
        if(ans) return "YES";
        else return "NO";
    }

    static void rec(String a, String b, int ia, int ib) {

        if(ans || memo[ia][ib] || a.length() - ia < b.length() - ib) return;
        memo[ia][ib] = true;

        if(ib == b.length()) {
            ans = true;
            for(int i = ia; i<a.length(); i++) ans = ans && a.charAt(i) - 'A' > 26;
            return;
        }

        int va = a.charAt(ia) - 'A';
        int vb = b.charAt(ib) - 'A';

        if(va > 26) rec(a, b, ia+1, ib);
        if(va == vb || va - 32 == vb) rec(a, b, ia + 1 , ib + 1);

    }

/*    static void rec(String a, String b, int ia, int ib, int upper) {

        if(ans || memo[ia][ib][upper] || a.length() - ia < b.length() - ib) return;
        memo[ia][ib][upper] = true;
        if(ib == b.length()) {
            ans = true;
            for(int i = ia; i<a.length(); i++) ans = ans && a.charAt(i) - 'A' > 26;
            return;
        }

        //System.out.println("ia: "+ia+" - ib: "+ib+" - upper: "+upper);

        int va = a.charAt(ia) - 'A';
        int vb = b.charAt(ib) - 'A';
        if(upper == 1) va -= 32;

        if(va == vb) rec(a, b, ia + 1 , ib + 1, 0);

        if(va > 26) {
            rec(a, b, ia+1, ib, 0);
            rec(a, b, ia, ib, 1);
        }
    }*/

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while(q-- > 0) {
            String a = in.nextLine();
            String b = in.nextLine();
            out.println(abbreviation(a, b));
        }
    }
}
