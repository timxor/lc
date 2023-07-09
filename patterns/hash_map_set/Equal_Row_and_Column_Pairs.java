// Equal Row and Column Pairs
// Hash Map / Set
// https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int equalPairs(int[][] grid) {
        
        // my first logic
        // 
        // store all paths for each row and col
        // then for each one check if there is existing exact match
        // row path set, column path set
        // for each row path, check in column path set, += 1
        // time complexity = n^2 + n
        // space complexity = n^2
        // 
        // to actually store a sequence of ints in a map or set
        // encode ints as string

        // store all paths in hashset
        HashSet<String> stringSet = new HashSet<>();
        HashSet<String> rowPathSet = new HashSet<>();
        HashSet<String> columnPathSet = new HashSet<>();

        // traverse only the rows in the grid
        for (int i = 0; i < grid.length; i++) {
            // Process the elements in the current row
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                int element = grid[i][j];
                // Perform operations on the element (e.g., print, modify, etc.)
                sb.append(element);
            }
            // Move to the next row
            // add each row path to the hashset
            String rowPath = sb.toString();
            rowPathSet.add(rowPath);
        }

        // Traverse the columns
        for (int j = 0; j < grid.length; j++) {
            // Process the elements in the current column
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                int element = grid[i][j];
                // Perform operations on the element (e.g., print, modify, etc.)
                sb.append(element);
            }
            // Move to the next column
            // add each column path to the hashset
            String columnPath = sb.toString();
            columnPathSet.add(columnPath);
        }

        // check for matches and add 1 for each match
        int result = 0;

        // Iterate over elements in rowPathSet
        for (String element : rowPathSet) {
            // Check if the element is present in columnPathSet
            if (columnPathSet.contains(element)) {
                // Element is present in columnPathSet
                result = result + 1;
            } 
        }
        
        return result;
    }
}