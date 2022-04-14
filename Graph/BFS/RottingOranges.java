package Graph.BFS;

import java.util.*;

// https://leetcode.com/problems/rotting-oranges/
// bfs, in-place
//

public class RottingOranges {

    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Input grid is null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 1 && cols == 1) {
            return grid[0][0] == 1 ? -1 : 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        int freshOrangesCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * cols + j);
                } else if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }

        int time = 0;
        // freshOrangesCount != 0 ==> This check ensure we are not continuing once all
        // fresh oranges have become rotten.
        while (freshOrangesCount != 0 && !queue.isEmpty()) {
            int levelSize = queue.size();
            time++; // Time elapsed after neighbors of this level have become rotten.
            for (int i = 0; i < levelSize && freshOrangesCount != 0; i++) {
                int cur = queue.poll();
                int row = cur / cols;
                int col = cur % cols;
                for (int[] d : DIRECTIONS) {
                    int x = row + d[0];
                    int y = col + d[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    freshOrangesCount--;
                    if (freshOrangesCount == 0) {
                        break;
                    }
                    queue.offer(x * cols + y);
                }
            }
        }

        return freshOrangesCount == 0 ? time : -1;
    }
}
