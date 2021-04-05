/* Peak index in mountain array
 *
 * Let's call a array A a mountain if the following properties hold
 *
 * A.length >= 3
 * There exists soem 0 < i < A.length - 1 such that A[0] < A[1] < ...
 * ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * Given an array that is definetely  a montain, return any i such that
 * A[0] < A[1] < .... A[i-1] < A[i] > A[i+1] > ... > A[A.lenght - 1]
 *
 * I: [0, 1, 0]
 * O: 1
 *
 * I: [0, 2, 1, 0]
 * O: 1
 */

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String args[]) {
        int A[] = {0, 2, 3, 2, 1, 0, 0};
        Solution sol = new Solution();
        System.out.println(sol.peakIndexInMountainArray(A));
    }
}

