public class MaximumTripletValue2 {

    public long maximumTripletValue(int[] nums) {

        int max0 = nums[0];
        long ans = 0L;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {

            if (max >= 0) {
                ans = Math.max(ans, (long)max * (long)nums[i]);
            }

            max = Math.max(max, max0 - nums[i]);

            max0 = Math.max(max0, nums[i]);

        }
        return ans;

    }
    
}
