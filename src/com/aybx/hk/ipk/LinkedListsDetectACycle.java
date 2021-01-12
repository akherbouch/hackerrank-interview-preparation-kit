package com.aybx.hk.ipk;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

public class LinkedListsDetectACycle {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            else return false;
            if (slow == fast) return true;
        }
        return false;
    }


/*    // it works but not the expected hh
    boolean hasCycle(Node head) {
        HashSet<Node> seenData = new HashSet<>();
        while (head != null) {
            if (seenData.contains(head)) return true;
            seenData.add(head);
            head = head.next;
        }
        return false;
    }*/

    public void solve(int testNumber, Scanner in, PrintWriter out) {
    }
}
