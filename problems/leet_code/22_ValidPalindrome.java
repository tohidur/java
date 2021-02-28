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

        char sa[] = tmp.toCharArray();

        while (b < e) {
            if (shouldSkip(sa[b])) {
                b++;
            } else if (shouldSkip(sa[e])) {
                e--;
            } else if (sa[b] != sa[e]) {
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

