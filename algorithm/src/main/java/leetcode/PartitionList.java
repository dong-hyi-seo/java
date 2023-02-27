package leetcode;

import java.util.Objects;

/**
 * @since 2023.02.25
 * URL : https://leetcode.com/problems/partition-list/
 * head연결된 목록과 값이 주어 지면 보다 작은 모든 노드가 보다 크거나
 * 같은 노드 앞에 오도록 x분할합니다 . xx
 * 두 파티션 각각에서 노드의 원래 상대 순서를 유지 해야 합니다 .
 * 리스트와 x가 주어집니다.
 * 리스트를 x보다 작은 것은 앞으로 크거나 같은것은 뒤로 보냅니다.
 * 큰 것을 정렬할 때 상대적 위치는 같아야합니다.
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */

public class PartitionList {

    /**
     * 연결된 노드중 x 보다 작은것에는 lessNode에
     * x 보다 같커나 큰 노드는 moreNode
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        System.out.println("head = " + head);
        System.out.println("x = " + x);
        ListNode lessHead = new ListNode();
        ListNode moreHead = new ListNode();
        ListNode lessNode = lessHead;
        ListNode moreNode = moreHead;
        ListNode node = head;
        while (node != null) {
            //node의 값이 x 보다 작으면 leftNode에
            if (node.val < x) {
                lessNode.next = node;
                lessNode = lessNode.next;
            } else {
                moreNode.next = node;
                moreNode = moreNode.next;
            }
            node = node.next;
        }
        moreNode.next = null;
        System.out.println("lessHead = " + lessHead + " // moreHead = " + moreHead);
        lessNode.next = moreHead.next;
        System.out.println("lessHead = " + lessHead);
        return lessHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }
}
