class Solution {
    public boolean backspaceCompare(String S, String T) {
        int S_ptr = S.length() - 1;
        int T_ptr = T.length() - 1;

        String S_esc = "";
        String T_esc = "";

        while (S_ptr >= 0) {
            char cur_char = S.charAt(S_ptr);
            S_ptr -= 1;
        }

        while (T_ptr >= 0) {
            char cur_char = S.charAt(S_ptr);
            T_ptr -= 1;
        }

        return true;
    }

    public static void main(String args[]) {
        String S = "ab#c";
        String T = "ad#c";

        Solution sol = new Solution();
        sol.backspaceCompare(S, T);
    }
}
