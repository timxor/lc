// Partition to K Equal Sum Subsets
//
// #698
//
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets



class Solution {

    int targetSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (Integer i : nums) sum += i;

        if (sum % k != 0 || nums.length < k) return false;

        targetSum = sum / k;

        int visited[] = new int[k];

        Arrays.sort(nums);

        return dfs(nums, k, nums.length-1, visited);
    }

    private boolean dfs(int nums[], int k, int numsLength, int visited[])
    {
        if (numsLength == -1) return true;

        boolean ans = false;

        for (int i = 0; i < k; i++) {
            if (visited[i] + nums[numsLength] <= targetSum) {
                visited[i] += nums[numsLength];
                if ( dfs(nums, k, numsLength - 1, visited) ) return true;
                visited[i] -= nums[numsLength];
            }
            if (visited[i] == 0) break;
        }
        return false;
    }
}





// Approach 1: Naive Backtracking -- time limit exception

class Solution {
    private boolean backtrack(int[] arr, int count, int currSum, int k, int targetSum, boolean[] taken) {
        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // Current subset sum exceeds target sum, no need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When current subset sum reaches target sum then one subset is made.
        // Increment count and reset current subset sum to 0.
        if (currSum == targetSum) {
            return backtrack(arr, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = 0; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrack(arr, 0, 0, k, targetSum, taken);
    }
}


// Approach 2: Optimized Backtracking

class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, boolean[] taken) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }
}

// Approach 3: Backtracking plus Memoization
class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, char[] taken, HashMap<String, Boolean> memo) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        String takenStr = new String(taken);

        // If we have already computed the current combination.
        if (memo.containsKey(takenStr)) {
            return memo.get(takenStr);
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, 0, count + 1, 0, k, targetSum, taken, memo);
            memo.put(takenStr, ans);
            return ans;
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (taken[j] == '0') {
                // Include this element in current subset.
                taken[j] = '1';

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken, memo)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = '0';
            }
        }

        // We were not able to make a valid combination after picking each element from array,
        // hence we can't make k subsets.
        memo.put(takenStr, false);
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;

        char[] taken = new char[n];
        for(int i = 0; i < n; ++i) {
            taken[i] = '0';
        }

        // Memoize the ans using taken element's string as key.
        HashMap<String, Boolean> memo = new HashMap<>();

        return backtrack(arr, 0, 0, 0, k, targetSum, taken, memo);
    }
}

// Approach 4: Backtracking plus Memoization with Bitmasking
class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, Integer mask, HashMap<Integer, Boolean> memo) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // If we have already computed the current combination.
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, 0, count + 1, 0, k, targetSum, mask, memo);
            memo.put(mask, ans);
            return ans;
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (((mask >> j) & 1) == 0) {
                // Include this element in current subset.
                mask = (mask | (1 << j));

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, mask, memo)) {
                    return true;
                }

                // Backtrack step.
                mask = (mask ^ (1 << j));
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        memo.put(mask, false);
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;
        Integer mask = 0;

        // Memoize the ans using taken element's string as key.
        HashMap<Integer, Boolean> memo = new HashMap<>();

        return backtrack(arr, 0, 0, 0, k, targetSum, mask, memo);
    }
}

// Approach 5: Tabulation plus Bitmasking



// best memory
// 80% runtime, 4ms, 40mb mem, 72% beats
class Solution {
    int sum,portion;

    boolean dfs(int nums[], int k, int ixd, int a[])
    {
        if(ixd==-1)
        {
            return true;
        }

        boolean ans = false;

        for(int i=0;i<k;i++)
        {
            if(a[i]+nums[ixd]<=portion )
            {
                a[i] += nums[ixd];
                if(dfs(nums,k,ixd-1,a))return true;
                a[i] -= nums[ixd];
            }
            if(a[i]==0)break;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        sum = 0;
        for(Integer i : nums)sum+=i;

        if(sum%k!=0 || nums.length<k) return false;

        portion = sum/k;
        int a[] = new int[k];

        System.out.println(portion);
        Arrays.sort(nums);
        return dfs(nums,k,nums.length-1,a);

    }
}


// best runtime
// 0ms runtime beats 100%, 41mb mem beats 49%
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int arrayLength = nums.length;
        int targetSum = 0;
        for(int i = 0; i < arrayLength; i++) {
            targetSum += nums[i];
        }
        if(targetSum % k != 0) {
            return false;
        }
        targetSum /= k;

        nums = quickSort(nums, 0, arrayLength - 1);
        boolean[] visited = new boolean[arrayLength];

        return depthFirstSearch(nums, visited, 0, 0, 0, targetSum, k);
    }

    boolean depthFirstSearch(int[] nums, boolean[] visited, int start, int currentSum, int count, int targetSum, int k) {
        if(count == k - 1) {
            return true;
        }
        if(currentSum == targetSum) {
            return depthFirstSearch(nums, visited, 0, 0, count + 1, targetSum, k);
        }

        for(int i = start; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            if(currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if(depthFirstSearch(nums, visited, i + 1, currentSum + nums[i], count, targetSum, k)) {
                    return true;
                }
                visited[i] = false;
            }

            if(currentSum == 0 || currentSum + nums[i] == targetSum) {
                return false;
            }

            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return false;
    }

    int[] quickSort(int[] array, int low, int high) {
        if(low >= high) {
            return array;
        }

        int greaterThanPivot = low, i = low + 1, lessThanPivot = high;
        int pivot = array[low];

        while(i <= lessThanPivot) {
            if(array[i] > pivot) {
                array = swap(array, greaterThanPivot++, i++);
            }
            else if(array[i] < pivot) {
                array = swap(array, i, lessThanPivot--);
            }
            else {
                i++;
            }
        }
        array = quickSort(array, low, greaterThanPivot - 1);
        array = quickSort(array, lessThanPivot + 1, high);

        return array;
    }

    int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }
}
