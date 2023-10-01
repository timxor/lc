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



//    public long maximumTripletValue(int[] nums) {
//        int n = nums.length;
//        long ans = 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = i+1; j < n; ++j) {
//                for (int k = j+1; k < n; ++k) {
//                    long test = nums[k];
//                    ans = Math.max(ans,test*(nums[i]-nums[j]));
//                }
//            }
//        }
//        return ans;
//    }
    
    
    
}



