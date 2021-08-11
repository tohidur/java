/*
 * Given array - A of non-negative integers.
 * half are odd and half are even
 * sort the array where a[i] is odd i is odd and where a[i] is even i is evren
 */

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;

        int n = A.length;

        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }

            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }

            if (i < n && j < n) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
        
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        Solution sol = new Solution();
        int[] ans = sol.sortArrayByParityII(A);
        for (int e : ans) {
            System.out.println(e);
        }
    }
}
