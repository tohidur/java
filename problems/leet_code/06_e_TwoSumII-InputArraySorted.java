/* Two sum II - input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number
 *
 * The function should return indices of the two numbers, where index1 must be
 * less than index2.
 *
 * - You may assume that each input would have exactly one solution and you
 *   may not use the same element twice.
 *
 * Input: [2, 7, 11, 15], target = 9
 * Output: [1,2]
 */


import java.io.*;
import java.util.*;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int a_ptr = 0;
        int b_ptr = numbers.length - 1;

        while (a_ptr < b_ptr) {
            int sum = numbers[a_ptr] + numbers[b_ptr];
            if (sum > target) {
                b_ptr -= 1;
            } else if (sum < target) {
                a_ptr += 1;
            } else {
                return new int[] {a_ptr+1, b_ptr+1};
            }
        }

        return new int[] {a_ptr+1, b_ptr+1};
    }

    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution sol = new Solution();
        int[] res = sol.twoSum(nums, target);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}


/* Notes:
 * When sorted array always try to use pointers
*/

