package Heap;
// https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    /*
    Approach 1: Heap (min heap)

    The idea is to init a heap "the smallest element first",
    and add all elements from the array into this heap one by one
    keeping the size of the heap always less or equal to k.

    That would results in a heap containing k largest elements of the array.

    The head of this heap is the answer, i.e. the kth largest element of the array.

    The time complexity of adding an element in a heap of size k is
    O(logk), and we do it N times that means
    O(N log k) time complexity for the algorithm.

    In Python there is a method nlargest in heapq library which has the same
    O(Nlogk) time complexity and reduces the code to one line.

    This algorithm improves time complexity, but one pays with
    O(k) space complexity.

    Complexity Analysis

    Time complexity : O(Nlogk).

    Space complexity : O(k) to store the heap elements.
     */


    //    Approach 1: Heap (min heap)
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums)
        {
            minHeap.add(n);

            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }



    //    Approach 1: Heap (min heap, simpler syntax)
    public int findKthLargest2(int[] nums, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for ( int i = 0; i < nums.length; i++)
        {
            minHeap.add(nums[i]);

            if( minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }


    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int[] ar=new int[20000+1];
            for(int n:nums){
                ar[n+10000]++;
            }
            int i=20000;
            while(i>=0){
                if(ar[i]>0){
                    if(k-ar[i]<=0){
                        return i-10000;
                    }else{
                        k-=ar[i];
                    }
                }
                i--;
            }
            return -1;
        }
    }


    class Solution3 {
        public int findKthLargest(int[] nums, int k) {

            int arr[] = new int[100001] ;


            int factor = 10000;


            for(int i:nums) {
                arr[i+factor]++;
            }

            int count = 0;
            for(int i=100000;i>=0;i--) {
                if(arr[i]>0) {
                    count+= arr[i];
                }

                if(count>=k) {
                    return i-factor;
                }
            }

            return -1;
        }
    }








    public static void main(String[] args) {

    }

}