/* Word Subsets
 *
 * 2 array A and B of words. Each word is a string of lowecase letters.
 *
 * Now say word b is a subset of a if every letter in b occurs in a,
 * including multiplicity. For example 'wrr' is a subset of 'warrior', but is
 * not a subset of 'world'.
 *
 * Now say a word a form A is universal if for every b in a, b is a subset of
 * a.
 *
 * Return a list of all universal words in A.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


class Solution {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        HashMap<String, HashMap<Character, Integer>> word_map 
            = new HashMap<>();
 
        for (String a : A) {
            HashMap<Character, Integer> char_map = new HashMap<>();
            word_map.put(a, char_map);
            for (char ca : a.toCharArray()) {
                if (!char_map.containsKey(ca)) {
                    char_map.put(ca, 1);
                } else {
                    char_map.put(ca, char_map.get(ca) + 1);
                }
            }
        }

        for (String ss : word_map.keySet()) {
            System.out.println(ss);
            if (ss == "appple") {
                for (Character cc : word_map.get(ss).keySet()) {
                    System.out.println(word_map.get(ss).get(cc));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] A = {"facebook", "google", "leetcode", "appple"};
        String[] B = {"e", "oo"};
        Solution s = new Solution();
        List<String> res = s.wordSubsets(A, B);

        for (String i : res) {
            System.out.println(i);
        }
    }

}

