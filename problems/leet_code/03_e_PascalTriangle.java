/* Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of pascals
 * triangle.
 *
 * Input: 5
 * Output: 
 * [
 *      [1]
 *     [1, 1]
 *    [1, 2, 1]
 *  [1, 3,  3, 1]
 * ]
 */


import java.io.*;
import java.util.*;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        if (numRows == 0) return arr;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        arr.add(firstRow);

        for (int i=1; i < numRows; i++) {
            List<Integer> prev_row = arr.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j=1; j<i; j++) {
                row.add(prev_row.get(j-1) + prev_row.get(j));
            }

            row.add(1);
            arr.add(row);
        }

        return arr;
    }

    public static void main(String args[]) {
        int num = 5;
        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(num);
        System.out.println(result);

        //for (int i=0; i < result.size(); i++) {
            //for (int j=0; j < result.get(i).size(); j++) {
                //System.out.println(result.get(i).get(j));
            //}
        //}
    }
}
