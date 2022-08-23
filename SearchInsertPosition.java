public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        if (end < start) {
            return start;
        }
        int middle = (start + end) / 2;
        if (middle >= nums.length || nums[middle] == target)
            return middle;

        if (target > nums[middle])
            return searchInsert(nums, target, middle + 1, end);

        return searchInsert(nums, target, start, middle - 1);
    }
}
