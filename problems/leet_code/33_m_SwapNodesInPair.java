/* Swap Nodes In Pair
 *
 * Give an linked list, swap every two adjancent nodes and return it's head.
 * You may not modify the values in the list's nodes, only node itself may be
 * changed
 *
 * I: 1 -> 2 -> 3 -> 4
 * O: 2 -> 1 -> 4 -> 3
 *
 * 2 -> 1 > 3 -> 4
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;

        while (cur.next != null && cur.next.next != null) {
            ListNode f = cur.next;
            ListNode s = cur.next.next;
            f.next = s.next;
            cur.next = s;
            cur.next.next = f;
            cur = cur.next.next;
        }

        return temp.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode res = sol.swapPairs(head);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

