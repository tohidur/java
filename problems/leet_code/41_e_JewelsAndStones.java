/*
 * String J representing types of stoes that are jewels, and S representing
 * the stones you have. Each char in S is a type of stones you have. You want
 * to know how many of these stones you have are also jewels.
 *
 * The letters in J are distinct. Letters are case sensitive.
 */


import java.util.HashSet;


class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> h = new HashSet<>();

        for (char i : J.toCharArray())
            h.add(i);

        int ans = 0;
        for (char i : S.toCharArray()) {
            if (h.contains(i))
                ans++;
        }

        return ans;
    }

    public static void main(String args[]) {
        String J = "aA";
        String S = "aAAbbbb";

        Solution sol = new Solution();
        System.out.println(sol.numJewelsInStones(J, S));
    }
}

