package DynamicProgramming;

public class LastStoneWeightII {

    // Last Stone Weight II
    // Array, DP, 0/1 Knapsack problem
    //
    //
    // https://leetcode.com/problems/last-stone-weight-ii/
    // https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/RM1BDv71V60
    //

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int n : stones) {
            sum += n;
        }

        boolean[] memo = new boolean[sum + 1];
        memo[0] = true;

        for (int n : stones) {
            for (int i = sum / 2; i >= n; --i) {
                memo[i] |= memo[i - n];
            }
        }

        for (int i = sum / 2; i >= 0; --i) if (memo[i]) return sum - i - i;
        return 0;
    }
}
