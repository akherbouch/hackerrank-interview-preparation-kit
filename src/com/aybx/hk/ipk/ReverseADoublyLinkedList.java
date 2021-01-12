package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class ReverseADoublyLinkedList {


    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode tail = head, tmp;
        while (tail.next != null) {
            tmp = tail.next;
            tail.next = tail.prev;
            tail.prev= tmp;
            tail = tail.prev;
        }
        tail.next = tail.prev;
        tail.prev= null;
        return tail;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {}

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }
}
