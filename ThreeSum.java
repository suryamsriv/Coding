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
            int i = 0, j = 1, k = 2, l, m;

            List<List<Integer>> tripletsArr = new ArrayList<>();
            int len = nums.length;
            while(i < len - 2) {
                ArrayList<Integer> triplets = new ArrayList<>();
                if(nums[i] + nums[j] + nums[k] == 0) {
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                }
                k++;
                if(k == len) {
                    j++;
                    if( j == len - 1) {
                        i++;
                        j = i + 1;
                    }
                    k = j + 1;
                }
                if(!triplets.isEmpty() && !tripletsArr.contains(triplets) && !isRedundant(triplets, tripletsArr))
                    tripletsArr.add(triplets);
            }
            return tripletsArr;
        }

        private boolean isRedundant(ArrayList<Integer> triplets, List<List<Integer>> tripletsArr) {
            if(tripletsArr.isEmpty())
                return false;

            HashMap<Integer,Integer> map1 = new HashMap<>();

            for(var v1: triplets)
            {
                if(map1.containsKey(v1))
                    map1.put(v1, map1.get(v1) + 1);
                else
                    map1.put(v1, 1);
            }

            for(var v2: tripletsArr) {
                HashMap<Integer,Integer> map2 = new HashMap<>();
                for(var v3: v2) {
                    if(map2.containsKey(v3))
                        map2.put(v3, map2.get(v3) + 1);
                    else
                        map2.put(v3, 1);
                }

                if(map2.equals(map1))
                    return true;
            }
            return false;
        }
    }