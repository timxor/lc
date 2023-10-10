// https://leetcode.com/problems/partition-equal-subset-sum/
// https://www.youtube.com/watch?v=3N47yKRDed0

class PartitionEqualSubsetSum {
  
  public boolean canPartition(int[] nums) {
      
    int total = 0;
    for(int i : nums) {
      total += i;
    }  
        
    if(total % 2 != 0) {
      return false;
    }
    
    
      return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());    
  }

  public boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state) {
    
    String current = index + "" + sum;
    
    if(state.containsKey(current)){
      return state.get(current);
    }
    
    if(sum * 2 == total){
      return true;
    }
    
    if(sum > total / 2 || index >= nums.length){
      return false;
    }
    
    boolean found = canPartition(nums, index+1, sum, total, state) ||
          canPartition(nums, index + 1, sum + nums[index], total, state);


    state.put(current, found);
    
    return found;  
  }

}