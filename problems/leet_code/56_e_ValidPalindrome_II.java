/* Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one char,
 * Judge whether you can make it a palindrome
 *
 * Input: "aba"
 * OUtput: True
 *
 * Input: "abca"
 * Output: True
 *
 * Note: String will onnly contain a to z
 */


class Solution {
    public boolean validPalindrome(String str) {
        int s=0, e=str.length() - 1, pe = 0;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                break;
            }

            pe += 2;
        }

        if (str.length() - pe > 2)
            return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "abda";
        Solution sol = new Solution();
        System.out.println(sol.validPalindrome(s));
    }
}

