import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


class Solution {
    public List<String> commonChars(String[] A) {
        List<String> common_chars = new ArrayList<>();

        int[] min_frequencies = new int[26];
        Arrays.fill(min_frequencies, Integer.MAX_VALUE);

        for (String current_string : A) {
            int[] char_frequencies = new int[26];

            for (char c : current_string.toCharArray()) {
                char_frequencies[c-'a']++;
            }

            for (int i=0; i<26; i++) {
                min_frequencies[i] = Math.min(min_frequencies[i],
                                              char_frequencies[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (min_frequencies[i] > 0) {
                common_chars.add("" + (char)(i+'a'));
                min_frequencies[i]--;
            }
        }

        return common_chars;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};

        Solution sol = new Solution();
        List<String> res = sol.commonChars(A);

        for (String i : res) {
            System.out.println(i);
        }
    }
}
