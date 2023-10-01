// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/

public class MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {

        int default_max = nums[0];
        long result = 0L;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {

            if (max >= 0) {
                result = Math.max(result, (long)max * (long)nums[i]);
            }

            max = Math.max(max, default_max - nums[i]);

            default_max = Math.max(default_max, nums[i]);
        }
        return result;
    }
}



