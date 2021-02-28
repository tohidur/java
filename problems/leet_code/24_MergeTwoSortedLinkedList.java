class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode tmp_node = new ListNode(-1);
        ListNode cur_node = tmp_node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur_node.next = l1;
                l1 = l1.next;
            } else {
                cur_node.next = l2;
                l2 = l2.next;
            }
            cur_node = cur_node.next;
        }
        cur_node.next = (l1 != null) ? l1 : l2;
        return tmp_node.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution sol = new Solution();
        ListNode res = sol.mergeTwoSortedLinkedList(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

