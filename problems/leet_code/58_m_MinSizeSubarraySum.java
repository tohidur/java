/* Min size subarray sum
 *
 * - Array of n positive integers and a positive integer s.
 * - Find the minimum length of a contiguous subarray of which the sum >= s.
 * - If there isn't one return 0 instaed.
 *
 *   Do it within - O(n log n)
 */


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;

        int left = 0;
        int val_sum = 0;

        for (int i=0; i<nums.length; i++) {

        }
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(s, nums));
    }
}
