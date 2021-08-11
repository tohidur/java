/*
 * Given a matrix A, return the transpose of A.
 *
 * Switching and rows and cloumns indices of the matrix
 */


class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] t = new int[cols][rows];

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                t[j][i] = A[i][j];
            }
        }

        return t;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution sol = new Solution();
        for (int[] i : sol.transpose(A)) {
            for (int j : i) {
                System.out.println(j);
            }
            System.out.println("=======\n");
        }
    }
}
