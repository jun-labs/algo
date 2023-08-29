package leetcode.SplitArrayLargestSum;

class Solution {

    private int[] numbers;

    public int splitArray(int[] nums, int k) {
        numbers = nums;
        long start = 0;
        long end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        long mid = -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isValid(mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int) start;
    }

    private boolean isValid(long target, int k) {
        int count = 1;
        long sum = 0;
        for (int number : numbers) {
            sum += number;
            if (sum > target) {
                sum = number;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
