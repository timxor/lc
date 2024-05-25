
// The Number of Beautiful Subsets
//
// #2597
//
// https://leetcode.com/problems/the-number-of-beautiful-subsets/



class TheNumberOfBeautifulSubsets {

    public int beautifulSubsets(int[] nums, int k) {
        // subsets generation = recursion
        // base case = when the input set is empty
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        return count(nums, k, map, 0) - 1;
    }

    private int count(int[] nums, int diff, Map<Integer, Integer> map, int i) {
        // base case
        if (i == nums.length) {
            return 1;
        }

        int result = count(nums, diff, map, i + 1);

        if (!map.containsKey(nums[i] - diff)) {
            // mark nums[i] as taken
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // recurse
            result += count(nums, diff, map, i + 1);
            // backtrack
            map.put(nums[i], map.get(nums[i]) - 1);

            // remove nums[i] from map if its count becomes 0
            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }
        }

        return result;
    }
}


// Approach 1: Using Bitset


class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return countBeautifulSubsets(nums, k, 0, 0);
    }

    private int countBeautifulSubsets(int[] nums, int difference, int index, int mask) {
        // Base case: Return 1 if mask is greater than 0 (non-empty subset)
        if (index == nums.length)
            return mask > 0 ? 1 : 0;

        // Flag to check if the current subset is beautiful
        boolean isBeautiful = true;

        // Check if the current number forms a beautiful pair with any previous number
        // in the subset
        for (int j = 0; j < index && isBeautiful; ++j){
            isBeautiful = ((1 << j) & mask) == 0 ||
                        Math.abs(nums[j] - nums[index]) != difference;
            }

        // Recursively calculate beautiful subsets including and excluding the current
        // number
        int skip = countBeautifulSubsets(nums, difference, index + 1, mask);
        int take;
        if (isBeautiful) {
            take = countBeautifulSubsets(nums, difference,
                    index + 1, mask + (1 << index));
        } else {
            take = 0;
        }

        return skip + take;
    }
}



// Approach 2: Recursion with Backtracking


class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        // Frequency map to track elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Sort nums array
        Arrays.sort(nums);
        return countBeautifulSubsets(nums, k, freqMap, 0) - 1;
    }

    private int countBeautifulSubsets(int[] nums, int difference, Map<Integer, Integer> freqMap, int i) {
        // Base case: Return 1 for a subset of size 1
        if (i == nums.length) {
            return 1;
        }
        // Count subsets where nums[i] is not taken
        int totalCount = countBeautifulSubsets(nums, difference, freqMap, i + 1);

        // If nums[i] can be taken without violating the condition
        if (!freqMap.containsKey(nums[i] - difference)) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) +
                    1); // Mark nums[i] as taken

            // Recursively count subsets where nums[i] is taken
            totalCount += countBeautifulSubsets(nums, difference, freqMap, i + 1);
            freqMap.put(nums[i], freqMap.get(nums[i]) -
                    1); // Backtrack: mark nums[i] as not taken

            // Remove nums[i] from freqMap if its count becomes 0
            if (freqMap.get(nums[i]) == 0) {
                freqMap.remove(nums[i]);
            }
        }

        return totalCount;
    }
}



// Approach 3: Optimised Recursion (Deriving Recurrence Relation)
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

        // Calculate frequencies based on remainder
        for (int num : nums) {
            Map<Integer, Integer> fr = freqMap.getOrDefault(num % k, new TreeMap<>());
            fr.put(num, fr.getOrDefault(num, 0) + 1);
            freqMap.put(num % k, fr);
        }

        // Calculate subsets for each remainder group
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            ArrayList<Pair<Integer, Integer>> subsets = new ArrayList<Pair<Integer, Integer>>(
                    entry.getValue().entrySet().size());
            for (Map.Entry<Integer, Integer> subsetEntry : entry.getValue().entrySet()) {
                subsets.add(
                        new Pair<>(subsetEntry.getKey(), subsetEntry.getValue()));
            }
            totalCount *= countBeautifulSubsets(subsets, subsets.size(), k, 0);
        }

        return totalCount - 1;
    }

    private int countBeautifulSubsets(ArrayList<Pair<Integer, Integer>> subsets,
            int numSubsets, int difference, int i) {
        // Base case: Return 1 for a subset of size 1
        if (i == numSubsets) {
            return 1;
        }

        // Calculate subsets where the current subset is not taken
        int skip = countBeautifulSubsets(subsets, numSubsets, difference, i + 1);
        // Calculate subsets where the current subset is taken
        int take = (1 << subsets.get(i).getValue()) - 1;

        // If next number has a 'difference', calculate subsets; otherwise, move
        // to next
        if (i + 1 < numSubsets &&
                subsets.get(i + 1).getKey() - subsets.get(i).getKey() == difference) {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 2);
        } else {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 1);
        }

        return skip + take; // Return total count of subsets
    }
}


// Approach 4: Dynamic Programming - Memoization


class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

        // Calculate frequencies based on remainder
        for (int num : nums) {
            int remainder = num % k;
            Map<Integer, Integer> fr = freqMap.getOrDefault(remainder, new TreeMap<>());
            fr.put(num, fr.getOrDefault(num, 0) + 1);
            freqMap.put(remainder, fr);
        }

        // Calculate subsets for each remainder group
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            List<Pair<Integer, Integer>> subsets = new ArrayList<>();
            for (Map.Entry<Integer, Integer> subset : entry.getValue().entrySet()) {
                subsets.add(new Pair<>(subset.getKey(), subset.getValue()));
            }
            int[] counts = new int[subsets.size()]; // Store counts of subsets for memoization
            Arrays.fill(counts, -1);
            totalCount *= countBeautifulSubsets(subsets, subsets.size(), k, 0, counts);
        }
        return totalCount - 1;
    }

    private int countBeautifulSubsets(List<Pair<Integer, Integer>> subsets,
            int numSubsets, int difference, int i, int[] counts) {
        // Base case: Return 1 for a subset of size 1
        if (i == numSubsets) {
            return 1;
        }

        // If the count is already calculated, return it
        if (counts[i] != -1) {
            return counts[i];
        }

        // Calculate subsets where the current subset is not taken
        int skip = countBeautifulSubsets(subsets, numSubsets, difference, i + 1, counts);

        // Calculate subsets where the current subset is taken
        int take = (1 << subsets.get(i).getValue()) - 1; // take the current subset

        // If the next number has a difference of 'difference',
        // calculate subsets accordingly
        if (i + 1 < numSubsets && subsets.get(i + 1).getKey()
                                - subsets.get(i).getKey() == difference) {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 2, counts);
        } else {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 1, counts);
        }

        return counts[i] = skip + take; // Store and return total count of subsets
    }
}


// Approach 5: Dynamic Programming - Iterative
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;

        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

        // Calculate frequencies based on remainder
        for (int num : nums) {
            int remainder = num % k;
        freqMap.computeIfAbsent(remainder, x -> new TreeMap<>())
            .merge(num, 1, Integer::sum);
        }

        // Iterate through each remainder group
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            int n = entry.getValue().size(); // Number of elements in the current group

            List<Map.Entry<Integer, Integer>> subsets = new ArrayList<>(
                    entry.getValue().entrySet());

            int[] counts = new int[n + 1]; // Array to store counts of subsets

            counts[n] = 1; // Initialize count for the last subset

            // Calculate counts for each subset starting from the second last
            for (int i = n - 1; i >= 0; i--) {

                // Count of subsets skipping the current subset
                int skip = counts[i + 1];

                // Count of subsets including the current subset
                int take = (1 << subsets.get(i).getValue()) - 1;

                // If next number has a 'difference',
                // calculate subsets; otherwise, move to next
                if (i + 1 < n && subsets.get(i + 1).getKey()
                        - subsets.get(i).getKey() == k) {
                    take *= counts[i + 2];
                } else {
                    take *= counts[i + 1];
                }

                // Store the total count for the current subset
                counts[i] = skip + take;
            }

            totalCount *= counts[0];
        }

        return totalCount - 1;
    }
}




// Approach 6: Dynamic Programming - Optimized Iterative
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

        // Calculate frequencies based on remainder
        for (int num : nums) {
            Map<Integer, Integer> fr = freqMap.getOrDefault(num % k, new TreeMap<>());
            fr.put(num, fr.getOrDefault(num, 0) + 1);
            freqMap.put(num % k, fr);
        }

        // Iterate through each remainder group
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
            int prevNum = -k, prev2 = 0, prev1 = 1, curr = 1;

            // Iterate through each number in the current remainder group
            for (Map.Entry<Integer, Integer> freqEntry : entry.getValue().entrySet()) {
                int num = freqEntry.getKey();
                int freq = freqEntry.getValue();
                // Count of subsets skipping the current number
                int skip = prev1;

                // Count of subsets including the current number
                // Check if the current number and the previous number
                // form a beautiful pair
                int take;
                if (num - prevNum == k) {
                    take = ((1 << freq) - 1) * prev2;
                } else {
                    take = ((1 << freq) - 1) * prev1;
                }

                curr = skip + take; // Store the total count for the current number
                prev2 = prev1;
                prev1 = curr;
                prevNum = num;
            }
            totalCount *= curr;
        }
        return totalCount - 1;
    }
}
