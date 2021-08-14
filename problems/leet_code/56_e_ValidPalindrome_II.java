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

        boolean del_s = false;
        boolean del_e = false;
 
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                if (!del_s) {
                    pe = 0;
                    s = 1;
                    del_s = true;
                } else if (!del_e) {
                    pe = 0;
                    e = str.length() - 1;
                    del_e = true;
                } else {
                    break;
                }
            }

            pe += 2;
        }

        if (str.length() - pe > 2)
            return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "eade";
        Solution sol = new Solution();
        System.out.println(sol.validPalindrome(s));
    }
}

