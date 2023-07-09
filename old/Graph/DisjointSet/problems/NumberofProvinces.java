package Graph.DisjointSet.problems;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-provinces/

class NumberofProvinces {

    // approach 1: dfs
    // approach 2: bfs
    // approach 3: union find
    //              time: O(n^3)
    //              space: O(n)

    int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);

        if(xset != yset){
            parent[xset] = yset;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < isConnected.length; i++){
            for (int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++){
            if (parent[i] == -1){
                count++;
            }
        }
        return count;
    }
}