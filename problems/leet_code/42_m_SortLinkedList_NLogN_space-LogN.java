/*
 * Sort linked list in O(n log n) time complexity and O(log n) space complexity
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };
}


class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(slow);

        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        if (l != null)
            cur.next = l;
        if (r != null)
            cur.next = r;

        return temp.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(9);
        ListNode cur = head;
        for (int i : new int[]{7, 5, 2, 3, 1, 4, 8, 6}) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        Solution sol = new Solution();
        ListNode ans = sol.sortList(head);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
