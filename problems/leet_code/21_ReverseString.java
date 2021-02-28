/* Reverse String
 * Write a function to reverse a string the input string is given as an
 * array of charecters.
 *
 * Do not alocate extra space for another array
 * All chars are printable ASCII chars
 */

class Solution {
    public void reverseString(char[] s) {
        int b = 0;
        int e = s.length - 1;

        while (b < e) {
            char tmp = s[b];
            s[b] = s[e];
            s[e] = tmp;

            b++;
            e--;
        }
    }

    public static void main(String args[]) {
        char a[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(a);
        Solution sol = new Solution();
        sol.reverseString(a);
        System.out.println(a);
    }
}


