package com.aybx.hk.ipk;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;

public class QueuesATaleOfTwoStacks {
    
    static class MyQueue<T> {

        private Stack<T> stk1, stk2;

        public MyQueue() {
            stk1 = new Stack<>();
            stk2 = new Stack<>();
        }

        public void enqueue(T x) {
            stk2.push(x);
        }

        public void dequeue() {
            if (stk1.isEmpty()) reFill();
            stk1.pop();
        }

        public T peek() {
            if (stk1.isEmpty()) reFill();
            return stk1.peek();
        }

        private void reFill() {
            while (!stk2.isEmpty()) {
                T x = stk2.pop();
                stk1.push(x);
            }
        }

    }
    
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = in.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(in.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                out.println(queue.peek());
            }
        }
        in.close();
    }
}
