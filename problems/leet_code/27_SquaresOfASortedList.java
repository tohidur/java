/* Squares of a sorted list
 *
 * Given an array of integers A sorted in non-decreasing order, return 
 * an array of the squares 
 */

class Solution {
    public int[] sortedSquares(int[] A) {
        int lenA = A.length;
        if (lenA == 0) return A;

        int[] sortedA = new int[lenA];
        int sortedACount = 0;

        int pvePtr = 0;
        while (A[pvePtr] < 0)
            pvePtr++;
        int nvePtr = pvePtr - 1;
        System.out.println(pvePtr);
        System.out.println(nvePtr);

        while (pvePtr < lenA && nvePtr > -1) {
            if (A[pvePtr] < (-1 * A[nvePtr])) {
                sortedA[sortedACount] = A[pvePtr] * A[pvePtr];
                pvePtr++;
            } else {
                sortedA[sortedACount] = A[nvePtr] * A[nvePtr];
                nvePtr--;
            }
            sortedACount++;
        }

        while (pvePtr < lenA)
            sortedA[sortedACount++] = A[pvePtr] * A[pvePtr++];
        while (nvePtr > -1)
            sortedA[sortedACount++] = A[nvePtr] * A[nvePtr--];

        return sortedA;
    }

    public static void main(String args[]) {
        int a[] = {-7, -3, 2, 3, 11};
        for (int i : a)
            System.out.print(i + ", ");
        System.out.println("After Sorting: ");
        Solution sol = new Solution();
        for (int i : sol.sortedSquares(a))
            System.out.print(i + ", ");
    }
}

