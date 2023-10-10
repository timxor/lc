// https://www.youtube.com/watch?v=FrWq2rznPLQ
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class KthLargestElementInAnArray {
  
  public int findKthLargest(int[] nums, int k) {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for(int i: nums) {
      minHeap.add(i);
      if(minHeap.size() > k) {
        minHeap.remove();
      }
    }  
  
  return minHeap.remove();    
  }
}