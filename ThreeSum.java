/*
15. 3Sum
Medium
24.8K
2.2K
Companies
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            int i, j, k, l, m;

            List<List<Integer>> tripletsArr = new ArrayList<>();


            // int triplets = new int[nums.length][nums.length];
            for(i = 0; i < nums.length - 2; i++)
            {
                for(j=i+1; j< nums.length - 1; j++) {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    for(k = j +1; k< nums.length; k++) {
                        if(nums[i] + nums[j] + nums[k] == 0) {
                            triplets.add(nums[i]);
                            triplets.add(nums[j]);
                            triplets.add(nums[k]);
                        }
                        if(!triplets.isEmpty() && !isRedundant(triplets, tripletsArr))
                            tripletsArr.add(triplets);
                    }
                }
            }
            return tripletsArr;
        }

        private boolean isRedundant(ArrayList<Integer> triplets, List<List<Integer>> tripletsArr) {
            if(tripletsArr.isEmpty())
                return false;
            Map<Integer, Integer> freq = new HashMap<>();

            for(var val: triplets) {
                if(freq.get(val) == null )
                    freq.put(val, 1);
                else
                    freq.put(val, freq.get(val) + 1);
            }

            for(var index : tripletsArr) {
                for(var value: index) {
                    if(freq.containsKey(value))
                        freq.put(value, freq.get(value) + 1);
                }

                int count = 0;
                for(var val: freq.values()) {
                    count += val;
                }
                if(count >=6)
                    return true;
            }
            return false;
        }
    }