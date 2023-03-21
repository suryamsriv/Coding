/*
4. Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


 */

public class MedianOfSortedArrays {
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int [] mergedArr = mergeArrays(nums1, nums2);
            double median = 0.0;
            int len = mergedArr.length;
            if(len % 2 == 0) {
                median = (double) (mergedArr[(len / 2) - 1] + mergedArr[(len / 2)])  / 2;
            }
            else
                median = mergedArr[(int)(len / 2)];

            return median;
        }

        private int[] mergeArrays(int[] nums1, int[] nums2) {
            int i = 0, j = 0, k = 0;
            int totalLength = nums1.length + nums2.length;
            int[] mergedArr = new int[totalLength];
            while (i < totalLength) {
                if (j < nums1.length && k < nums2.length) {
                    if (nums1[j] < nums2[k]) {
                        mergedArr[i++] = nums1[j++];
                    } else {
                        mergedArr[i++] = nums2[k++];
                    }
                } else {
                    if (j < nums1.length)
                        mergedArr[i++] = nums1[j++];
                    if (k < nums2.length)
                        mergedArr[i++] = nums2[k++];
                }
            }
            return mergedArr;
        }
}
