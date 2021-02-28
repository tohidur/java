/* Middle of Linked List
 *
 * Given a non-empty, singly linked list with head node `head`, return the
 * middle node of a linked list.
 * if there are two middle node return the second middle node.
 */
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;

        int slow_c = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            slow_c++;
        }
        if (fast.next == null)
            return slow;
        return slow.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        Solution sol = new Solution();
        System.out.println(sol.middleNode(head).val);
    }
}
