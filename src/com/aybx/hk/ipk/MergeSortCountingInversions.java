package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class MergeSortCountingInversions {

    static long countInversions(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length-1);
    }

    static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) return 0;
        int middle = (leftStart + rightEnd) / 2;
        return mergeSort(arr, temp, leftStart, middle)
                + mergeSort(arr, temp, middle + 1, rightEnd)
                + mergeHalves(arr, temp, leftStart, rightEnd);
    }

    static long mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long ans = 0;
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int index = left;
        while(left <= leftEnd && right <= rightEnd) {
            if(arr[left] > arr[right]) {
                temp[index] = arr[right];
                right++;
                ans += leftEnd - left + 1;
            } else {
                temp[index] = arr[left];
                left++;
            }
            index++;
        }


        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);// one of them will work
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);// one of them will work
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);

        return ans;

    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int d = in.nextInt();
        while(d-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = in.nextInt();
            }
            out.println(countInversions(arr));
        }
    }
}
