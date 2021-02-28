/**
 * To represent is a cycle in the given linked list, we use an integer,
 * pos which represents  the position (0-indexed) in the linked list where
 * tail connects to. If pos is -1 then there is no cycle in the linked list
 *
 * Ex: Input: head = [3,2,0,-4], pos = 1
 *     Output: true
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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow=head;
        ListNode fast=head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        // head.next.next.next.next = head.next;

        Solution sol = new Solution();
        System.out.println(sol.hasCycle(head));
    }
}

