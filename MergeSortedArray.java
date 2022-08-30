public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, j = 0, k;
        int shiftCount = 0;

        for (i = 0; i < m + shiftCount; i++) {
            if (j < n) {
                boolean shiftCheck = (m == 0 || i < m + shiftCount) ? (nums1[i] > nums2[j])
                        : (nums1[i] != 0) ? (nums1[i] > nums2[j]) : false;
                if (shiftCheck) {
                    shiftCount++;
                    for (k = m + shiftCount - 1; k > i; k--)
                        nums1[k] = nums1[k - 1];
                    nums1[i] = nums2[j++];
                }
            }
        }
        while (j < n)
            nums1[i++] = nums2[j++];
    }
}
