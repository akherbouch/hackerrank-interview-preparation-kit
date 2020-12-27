package com.aybx.hk.ipk;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;

public class SwapNodesAlgo {


  
/*    static void in_order(int[][] nodes, int cur) {
        if (nodes[cur][0] > 0) in_order(nodes, nodes[cur][0]);
        str.append(cur+" ");
        if (nodes[cur][1] > 0) in_order(nodes, nodes[cur][1]);
    }*/
    
    static int dfs(int[][] nodes, int curNode, int startIndex, int[] out) {
        if(curNode == -1) return startIndex;
        curNode--;// indexing start by 1
        int nextIndex = dfs(nodes, nodes[curNode][0], startIndex, out);
        out[nextIndex] = curNode + 1;
        return dfs(nodes, nodes[curNode][1], nextIndex + 1, out);
    }

/*    static void calcDepths(int[][] nodes, int cur, int d) {
        depth[cur] = d;
        if (nodes[cur][0] > 0) calc_depth(nodes, nodes[cur][0], d + 1);
        if (nodes[cur][1] > 0) calc_depth(nodes, nodes[cur][1], d + 1);
    }*/
    
    static void bfs(int[][] nodes, int[] depth) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        depth[0] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            int child;
            for(int i = 0; i < 2; i++) {
                child = nodes[node][i];
                if(child != -1) {
                    child--;// indexing start by 1
                    q.add(child);
                    depth[child] = depth[node] + 1;
                }
            }
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] ans = new int[queries.length][indexes.length];
        int[] depth = new int[indexes.length];

        bfs(indexes, depth);

        for (int q = 0; q < queries.length; q++) {
            for (int n = 0; n < indexes.length; n++){
                if (depth[n] % queries[q] == 0) {
                    int tmp = indexes[n][0];
                    indexes[n][0] = indexes[n][1];
                    indexes[n][1] = tmp;
                }
            }
            dfs(indexes, 1, 0, ans[q]);
        }
        return ans;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = Integer.parseInt(in.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = in.nextLine().split(" ");
            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(in.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(in.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);
        StringBuilder str = new StringBuilder();

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                str.append(result[resultRowItr][resultColumnItr]);
                if (resultColumnItr != result[resultRowItr].length - 1) {
                    str.append(" ");
                }
            }
            if (resultRowItr != result.length - 1) {
                str.append("\n");
            }
        }

        out.println(str);


    }
}
