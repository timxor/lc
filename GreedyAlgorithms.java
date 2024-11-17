/*

    Top 5 Greedy Algorithm Interview Questions


    Activity Selection Problem
    This problem involves selecting the maximum number of non-overlapping activities that can be performed
    by a single person, given their start and finish times12.
    LeetCode equivalent: #435 Non-overlapping Intervals
    https://leetcode.com/problems/non-overlapping-intervals/description/


    Job Sequencing Problem
    Given a set of jobs with deadlines and associated profits, the task is to find the sequence of jobs
    that maximizes total profit3.
    LeetCode equivalent: #1235 Maximum Profit in Job Scheduling
    https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/


    Huffman Coding
    This algorithm is used for lossless data compression, where the most frequent characters get shorter codes1.
    LeetCode equivalent: #1167 Minimum Cost to Connect Sticks
    https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/


    Fractional Knapsack Problem
    In this problem, you need to maximize the value of items you can put in a knapsack with a
    weight limit, allowing for fractions of items12.
    LeetCode equivalent: #322 Coin Change (a variation of the problem)
    https://leetcode.com/problems/coin-change/description/


    Minimum Spanning Tree (Kruskal's or Prim's Algorithm)
    These algorithms find the minimum spanning tree for a weighted, undirected graph12.
    LeetCode equivalent: #1584 Min Cost to Connect All Points
    https://leetcode.com/problems/min-cost-to-connect-all-points/description/


    Jump game - https://leetcode.com/problems/jump-game/description/
    Gas Station - https://leetcode.com/problems/gas-station/description/
    Assign Cookies - https://leetcode.com/problems/assign-cookies/description/
    Candy - https://leetcode.com/problems/candy/description/
    Non-overlapping Intervals - https://leetcode.com/problems/non-overlapping-intervals/description/
    Maximum Swap - https://leetcode.com/problems/maximum-swap/description/


    Greedy Related Problems
    https://leetcode.com/problem-list/50f6p33i/


    Top Greedy Questions helpful for OA and Interviews
    https://leetcode.com/discuss/interview-question/3972722/Top-Greedy-Questions-helpful-for-OA-and-Interviews


    ABCs of Greedy
    https://leetcode.com/discuss/general-discussion/1061059/ABCs-of-Greedy

*/


import java.util.Arrays;

public class GreedyAlgorithms {

    public GreedyAlgorithms() {

    }

    public static void main(String[] args) {

        System.out.println("Running GreedyAlgorithms.java file.");

        int[] nums = {2,3,1,1,4};
        boolean expected = true;
        boolean result = canJump(nums);
        System.out.println("nums[] = " + Arrays.toString(nums));
        System.out.println("canJump(nums) = " + result + ", expected = " + expected);

    }



    // Jump game
    // https://leetcode.com/problems/jump-game/description/
    // greedy approach - time o(n), space o(1)

    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }

//    int reachable = 0;
//    for (int i = 0; i < nums.length; i++) {
//        if (i > reachable) return false;
//        reachable = Math.max(reachable, i + nums[i]);
//    }
//    return true;

}



















