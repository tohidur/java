/* Spiral Matrix
 *
 * Return all the elements of the matrix in spiral order
 *
 * I: [
 *      [1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]
 *    ]
 * O: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * 1 2 3 4 5 6 7 2
 * 8 9 0 1 2 3 4 3
 * 5 6 7 8 9 0 1 2
 * 2 3 4 5 6 7 8 2 
 * 9 0 1 2 3 4 5 3
 * 2 3 4 5 6 7 7 3
 * 2 3 4 6 1 2 5 2
 */

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;


        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            for (int i=columnBegin; i <= columnEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            for (int i=rowBegin; i<=rowEnd; i++) {
                res.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            if (rowBegin <= rowEnd) {
                for (int i=columnEnd; i>=columnBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][columnBegin]);
                }
            }

            columnBegin++;
        }

        return res;
    }

    public static void main(String args[]) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Solution sol = new Solution();
        List<Integer> a = sol.spiralOrder(m);

        for (int i : a) {
            System.out.println(i);
        }
    }
}

