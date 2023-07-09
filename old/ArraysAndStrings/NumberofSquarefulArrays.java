package ArraysAndStrings;

import java.util.Arrays;


//https://leetcode.com/problems/number-of-squareful-arrays/
//
// backtracking
//
// time: O(N!*N)

public class NumberofSquarefulArrays {


    int res = 0;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        dfs(A, 0, -1);
        return res;
    }

    private void dfs(int[] A, int cnt, int prev) {
        // already visited all the numbers
        if (cnt == A.length) {
            res++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            // skip the number that is already visited
            if (A[i] == -1) continue;

            // skip the number that is equal to left one (same with permutation de-duplication)
            if (i > 0 && A[i] == A[i - 1]) continue;

            // skip the number that added to prev is not squareful
            int root = (int)Math.sqrt(A[i] + prev);
            if (prev != -1 && root * root != A[i] + prev) continue;

            int tmp = A[i]; // remember the number
            A[i] = -1;      // then make it as visited (use -1)
            dfs(A, cnt + 1, tmp);
            A[i] = tmp;     // restore the number
        }
    }




}
