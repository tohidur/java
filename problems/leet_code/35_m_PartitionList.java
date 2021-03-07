/* Partion List
 * 
 * Given a linkedlist and a vlue x, parition it such that all nodes less than
 * x come before nodes greater than or equal to x
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode lhs = new ListNode(0);
        ListNode lcur = lhs;

        ListNode rhs = new ListNode(0);
        ListNode rcur = rhs;

        while (head != null) {
            if (head.val < x) {
                lcur.next = head;
                lcur = lcur.next;
            } else {
                rcur.next = head;
                rcur = rcur.next;
            }
            head = head.next;
        }

        lcur.next = rhs.next;
        rcur.next = null;
        return lhs.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        Solution sol = new Solution();
        ListNode res = sol.partition(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}


