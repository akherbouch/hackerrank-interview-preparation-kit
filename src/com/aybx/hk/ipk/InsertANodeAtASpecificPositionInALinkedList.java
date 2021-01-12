package com.aybx.hk.ipk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class InsertANodeAtASpecificPositionInALinkedList {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode cur = head, tmp;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        while (--position > 0) cur = cur.next;
        tmp = cur.next;
        cur.next = newNode;
        newNode.next = tmp;
        return head;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        SinglyLinkedList ll = new SinglyLinkedList();
        while (n-- > 0) {
            ll.insertNode(in.nextInt());
        }
        int data = in.nextInt();
        int position = in.nextInt();
        SinglyLinkedListNode node = insertNodeAtPosition(ll.head, data, position);
        while (node != null) {
            out.print(node.data);
            node = node.next;
            if (node != null) {
                out.print(" ");
            }
        }

    }


    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

}
