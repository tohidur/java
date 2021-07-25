/* Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome
 *
 * Do it in O(n) time and O(1) space
 *
 */


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

    public boolean isPalindrom(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reversed(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public ListNode reversed(ListNode head) {
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
        s.next.next = new ListNode(5);
        s.next.next.next = new ListNode(2);
        s.next.next.next.next = new ListNode(1);

        Solution sol = new Solution();
        boolean res = sol.isPalindrom(s);
        System.out.println(res);
    }
}

