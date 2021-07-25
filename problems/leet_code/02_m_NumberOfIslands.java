/* Number of Islands
 *
 * Given a 2d grid map 1's land and 0's water, count the number of islands.
 * An island is surrounded by water and is formed by connecting adjancent
 * lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 *
 *
 * Example 1
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */

import java.io.*;


class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                };
            }
        }

        return count;
    }

    public void callBFS(char[][]grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        callBFS(grid, i+1, j);
        callBFS(grid, i-1, j);
        callBFS(grid, i, j+1);
        callBFS(grid, i, j-1);

    }

    public static void main(String args[]) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        Solution sol = new Solution();
        System.out.println("Solution - " + sol.numIslands(grid));

        //for (int i=0; i < grid.length; i++) {
            //for (int j=0; j < grid[i].length; j++) {
                //System.out.println(grid[i][j]);
            //};
        //}
    }
}
