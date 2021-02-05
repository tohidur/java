import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };

    public int getVal() {
        return this.val;
    }
}


class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String args[]) {
        ListNode s = new ListNode(1);
        s.next = new ListNode(2);
        s.next.next = new ListNode(3);
        s.next.next.next = new ListNode(4);
        s.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        ListNode res = sol.reverseList(s);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

