package leetcode;

/**
 * @since 2023.02.25
 * URL : https://leetcode.com/problems/linked-list-cycle-ii/
 *
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
