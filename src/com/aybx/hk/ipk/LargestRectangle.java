package com.aybx.hk.ipk;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class LargestRectangle {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int[] leftSmallIndex = new int[n];
        int[] rightSmallIndex = new int[n];
        Stack<Integer> indicesStk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indicesStk.isEmpty() && arr[indicesStk.peek()] >= arr[i]) indicesStk.pop();
            leftSmallIndex[i] = indicesStk.isEmpty() ? -1 : indicesStk.peek();
            indicesStk.push(i);
        }
        indicesStk.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!indicesStk.isEmpty() && arr[indicesStk.peek()] >= arr[i]) indicesStk.pop();
            rightSmallIndex[i] = indicesStk.isEmpty() ? n : indicesStk.peek();
            indicesStk.push(i);
        }
        int ans = 0;
        for (int i = 0; i<n; i++) {
            int area = arr[i]*(rightSmallIndex[i] - leftSmallIndex[i] - 1);
            ans = Math.max(ans, area);
        }
        out.println(ans);
    }
}
