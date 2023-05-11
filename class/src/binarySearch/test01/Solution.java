package binarySearch.test01;

public class Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int num = nums[mid];
            if (num == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
