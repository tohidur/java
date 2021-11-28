/* Question
 * 
 * Write an efficient algo which searches for a value in an mxn matrix.
 * This matrix has the following properties.
 *
 * - integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of
 *   the previous row.
 *
 * Example
 *
 * Input:
 * matrix = [
 *  [1, 3, 5, 7],
 *  [10, 11, 16, 20], 
 *  [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            int midpoint_element = matrix[midpoint / columns][midpoint % columns];
            if (midpoint_element == target) {
                return true;
            } else if (target < midpoint_element) {
                right = midpoint - 1;
            } else if (target > midpoint_element) {
                left = midpoint + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20},{23, 30, 34, 50}};

        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(matrix, 30));
    }
}
