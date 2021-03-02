/* Sum of 3 numbers closest to target
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume each input would have exactly one solution.
 *
 * Ex:
 *      Input: nums = [-1, 2, 1, -4];  target = 1
 *      Output: 2 (-1 2 1)
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        int cur_sum = sum;
        int ptr = 1;

        while (ptr + 2 < nums.length) {
            cur_sum = nums[ptr] + nums[ptr+1] + nums[ptr+2];
            if (Math.abs(target - cur_sum) < Math.abs(target - sum)) {
                sum = cur_sum;
            }
            ptr++;
        }
        return sum;
    }

    public static void main(String args[]) {
        int a[] = {-1, 2, 1, -4};
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(a, 2));
    }
}
