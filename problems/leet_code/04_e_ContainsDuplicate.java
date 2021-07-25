/* Contains Duplicate
 *
 * Give an array of integers, find if the array contains any duplicates.
 *
 */

import java.io.*;
import java.util.*;


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();

        for (int i =0; i< nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }

            numbers.add(nums[i]);
        }

        return false;

    }

    public boolean containsDuplicateBySorting(int[] nums) {
        Arrays.sort(nums);

        for (int i=0; i < nums.length; i++) {
            if (i == 0)
                continue;

            if (nums[i] == nums[i-1])
                return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3, 1};
        Solution sol = new Solution();
        System.out.println(sol.containsDuplicate(a));
        System.out.println(sol.containsDuplicateBySorting(a));
    }
}
