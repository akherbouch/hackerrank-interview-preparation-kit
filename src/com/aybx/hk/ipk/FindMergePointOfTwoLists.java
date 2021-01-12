package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;

public class FindMergePointOfTwoLists {



    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode tmp = head1;
        int l1 = 0;
        while (tmp != null) {
            tmp = tmp.next;
            l1++;
        }
        int l2 = 0;
        tmp = head2;
        while (tmp != null) {
            tmp = tmp.next;
            l2++;
        }
        while (l1 > l2) {
            head1 = head1.next;
            l1--;
        }
        while (l2 > l1) {
            head2 = head2.next;
            l2--;
        }

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;
    }

/* genius trick int FindMergeNode(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        while(currentA != currentB){
            if(currentA.next == null){
                currentA = headB;
            }else{
                currentA = currentA.next;
            }
            if(currentB.next == null){
                currentB = headA;
            }else{
                currentB = currentB.next;
            }
        }
        return currentB.data;
    }*/

    public void solve(int testNumber, Scanner in, PrintWriter out) { }

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
    }
}
