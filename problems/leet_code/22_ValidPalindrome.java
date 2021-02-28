/*Valid Palindrome
 * Given a string determine if it's a palindrome
 * considering only alpha numeric chars and ignoring cases
 *
 * Note: empty string is a valid palindrome
 */

import java.util.*;

class Solution {
    private boolean shouldSkip(char c) {
        if (c == ' ' || c == '\n' || c == '\t')
            return true;

        if (!Character.isLetterOrDigit(c))
            return true;

        return false;
    }
    
    public boolean isPalindrome(String s) {
        String tmp = s.toLowerCase();
        int b = 0;
        int e = s.length() - 1;

        if (e == 0) return true;

        while (b < e) {
            char b_char = tmp.charAt(b);
            char e_char = tmp.charAt(e);

            if (shouldSkip(b_char)) {
                b++;
            } else if (shouldSkip(e_char)) {
                e--;
            } else if (b_char != e_char) {
                return false;
            } else {
                b++;
                e--;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(s));
    }
}

