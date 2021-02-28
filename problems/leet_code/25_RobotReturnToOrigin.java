/* Robot Return To Origin
 *
 * There is a robot starting at position 0,0 the origin on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0,0) after
 * it complets it moves.
 *
 * The moves sequence is represented by a string, and the character moves[i]
 * rempresents it's ith move. Valid moves are R, L, U, D
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int x=0, y=0;
        for (char m : moves.toCharArray()) {
            if (m == 'R') {
                x++;
            } else if (m == 'L') {
                x--;
            } else if (m == 'U') {
                y++;
            } else {
                y--;
            }
        }

        return (x==0 && y==0);
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        String moves = "UDRLLRDU";
        System.out.println(sol.judgeCircle(moves));
    }
}
