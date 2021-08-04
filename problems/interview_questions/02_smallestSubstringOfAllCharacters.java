/* Smallest Substring of All Characters
 *
 * - Array of unique chars arr and a string str.
 * - Implement - getShortestUniqueSubstring
 * - Find the smallest substring of str contains all the chars in arr.
 * - return "" (empty string) if substring doesn't exists
 *
 * - Optimal sulution for both time and space complexity
 * 
 *
 * I: arr = ['x', 'y', 'z'], str = 'xyyzyzyx'
 * O: zyx
 *
 * Constraints:
 *   -> time limit - 5000 ms
 *   -> 1 <= array.characters <= 30
 *   -> 1 <= str.length <= 500
 */

import java.util.HashSet;
import java.util.ArrayList;


class Solution {
    static String getShortestUniqueSubstring(char[] arr, String str) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char e : arr)
            uniqueChars.add(e);
        ArrayList<String> substrings = new ArrayList<>();
        ArrayList<Character> substr_chars = new ArrayList<>();

        char[] str_chars = str.toCharArray();
        int sidx = 0, eidx = 0;
        HashSet<Character> uniqueCharsFound = new HashSet<>();
        while (eidx < str.length()) {
            // System.out.println(eidx);
            while (uniqueCharsFound.size() < uniqueChars.size() && eidx < str.length()) {
                // System.out.println(eidx);
                char e_char = str_chars[eidx];
                if (str_chars[sidx] == e_char && sidx < eidx) {
                    sidx++;
                    substr_chars.remove(0);
                    // System.out.println("=====");
                    // System.out.println(sidx);
                    // System.out.println(eidx);
                    // System.out.println("=====");
                    continue;
                } else {
                    uniqueCharsFound.add(e_char);
                    substr_chars.add(e_char);
                }
                eidx++;
            }

            if (uniqueCharsFound.size() == uniqueChars.size()) {
                String substr = "";
                for (Character c : substr_chars) {
                    substr = substr + c;
                }
                substrings.add(substr);
            } else {
                break;
            }

            uniqueCharsFound.clear();
            substr_chars.clear();
            sidx++;
            eidx = sidx;
        }

        String smallest_substr = null;
        int last_substr_length = Integer.MAX_VALUE;
        for (String s : substrings) {
            if (s.length() < last_substr_length) {
                smallest_substr = s;
                last_substr_length = s.length();
            }
        }

        return smallest_substr;
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'y', 'z'};
        String str = "xyyzyzyx";
        Solution sol = new Solution();
        sol.getShortestUniqueSubstring(arr, str);
        System.out.println(sol.getShortestUniqueSubstring(arr, str));
    }
}

