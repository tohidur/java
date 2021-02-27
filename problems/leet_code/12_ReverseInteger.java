class Solution {
    public int reverse(int x) {
        int rev = 0;

        while(x > 0) {
            int pow = x % 10;
            x /= 10;
            rev = rev * 10 + pow;
        }
        if (rev > Integer.MAX_VALUE)
            return 0;

        return rev;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(9812431));
    }
}

