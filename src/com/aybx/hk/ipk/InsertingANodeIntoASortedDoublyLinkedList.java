package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class InsertingANodeIntoASortedDoublyLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode cur = head, prev = null;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        while (cur != null && data > cur.data) {
            prev = cur;
            cur = cur.next;
        }
        if (prev == null) {
            newNode.next = head;
            return newNode;
        }
        prev.next = newNode;
        newNode.next = cur;
        return head;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) { }


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
