/* Remove K Digits
 *
 * Given a non-negative integers num represents as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 *
 * Note:
 *      - The length of num is less than 10002 and will be >= k.
 *
 *      - The given num does not contain any leading zero.
 *
 *  Example:
 *      - Input: num = "1432219", k = 3
 *        Output: "1219"
 *        Explanation: Remove the three digits 4, 3, and 2 to form the new
 *                     number 1219 which is the smallest.
 *
 *      - Input: num = "10200", k = 1
 *        Output: "200"
 *        Explanation: Remove the leading 1 and the number is 200. Note that
 *                     the output must contain leading zero.
 *
 *      - Input: num = "10", k = 2
 *        Output: "0"
 *        Explanation: Nothing is left so - Zero.
 */

import java.util.Stack;

class Solution {
    public String removeKDigits(String num, int k) {
        int size = num.length();
        if (k == size) return "0";

        Stack<Character> stack = new Stack<>();

        int counter = 0;
        while (counter < size) {

            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(counter));
            counter++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char current_char  = stack.pop();
            sb.append(current_char);
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeKDigits("1432219", 3));
        System.out.println(sol.removeKDigits("10200", 1));
        System.out.println(sol.removeKDigits("10", 2));
    }
}

