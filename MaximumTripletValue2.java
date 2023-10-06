public class MaximumTripletValue2 {

    // 2874. Maximum Value of an Ordered Triplet II
// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/

//    class Solution {
        public long maximumTripletValue(int[] nums) {

            long triplet_max = 0, pair_max = 0, max_element = 0;

            for (int i : nums) {
                triplet_max = Math.max(triplet_max, 1L * pair_max * i);
                pair_max = Math.max(pair_max, max_element - i);
                max_element = Math.max(max_element, i);
            }
            return triplet_max;
        }
//    }
}
