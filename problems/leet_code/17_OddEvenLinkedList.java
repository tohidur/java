class ListNode {
    public int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode odd_head = odd;
        ListNode even = head.next;
        ListNode even_head = even;

        ListNode cur = head.next.next;
        int count = 1;

        while (cur != null) {
            if (count % 2 == 0) {
                even.next = cur;
                even = even.next;
            } else {
                odd.next = cur;
                odd = odd.next;
            }
            count += 1;
            cur = cur.next;
        }

        odd.next = even_head;
        even.next = null;
        return odd_head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        Solution sol = new Solution();
        ListNode res = sol.oddEvenList(head);

        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
