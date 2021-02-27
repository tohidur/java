class Solution {
    public String toLowerCase(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += (char)(c + 32);
            } else {
                result += c;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        String str = "HeLLo";
        Solution sol = new Solution();
        System.out.println(sol.toLowerCase(str));
    }
}
