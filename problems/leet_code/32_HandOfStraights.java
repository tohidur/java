/* Hand of Straigts
 *
 * Alice has a hand of cards, given as a array of integers
 *
 * Now she wants to rearrange the cards into groups so that each group size is
 * W, and consista of W consecutive cards.
 *
 * Return true if and only if she can.
 */
import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> card_counts = new TreeMap<>();
        for (int card : hand) {
            if (!card_counts.containsKey(card)){
                card_counts.put(card, 1);
            } else {
                card_counts.replace(card, card_counts.get(card) + 1);
            }
        }

        while (card_counts.size() > 0) {
            int first_card = card_counts.firstKey();
            for (int i = first_card; i < first_card + W; i++) {
                if (!card_counts.containsKey(i)) return false;
                int count = card_counts.get(i);
                if (count == 1) {
                    card_counts.remove(i);
                } else {
                    card_counts.replace(i, card_counts.get(i) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int h[] = {34,80,89,15,38,69,19,17,97,98,26,77,8,31,79,70,103,3,13,
                   21,81,53,33,14,60,68,33,59,84,23,97,90,76,82,66,83,23,22,
                   16,18,98,25,16,61,84,100,4,68,101,25,23,9,10,55,2,67,39,52,
                   102,99,40,11,83,24,81,53,96,23,13,24,99,67,22,51,31,58,78,
                   88,5,15,24,32,81,91,96,16,54,22,56,69,14,82,32,34,83,24,37,
                   82,54,21};
        Solution sol = new Solution();
        System.out.println(sol.isNStraightHand(h, 4));
    }
}

