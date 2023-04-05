package leetcode.leetcode75_1.day3;

import java.util.Objects;

/**
 * @since 2023.03.02
 * URL : https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan&id=level-2
 * 목록 끝에서 N번째 노드 제거
 * 연결 된 목록의 head가 주어지면 목록 끝에서 노드를 제거하고 헤드를 반환 한다. n^th
 *
 * 입력: 헤드 = [1,2,3,4,5], n = 2
 * 출력: [1,2,3,5]
 *
 * 입력: 헤드 = [1], n = 1
 * 출력: []
 *
 * 입력: 헤드 = [1,2], n = 1
 * 출력: [1]
 *
 * 제약:
 * 목록의 노드 수는 입니다 sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 1,2,3,4,5
     * n = 2;
     * 1,2,3,5
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        //더미노드로부터 출발
        ListNode fast = dummy;
        ListNode slow = dummy;

        //fast와 slow사이에 n만큼! fast가 n만큼 더간다
        for (int i=0; i<n+1; i++) {
            fast = fast.next;
        }

        //fast가 next로 이동하면서 null일떄까지 가게되면 그때 같이 이동한 slow의 다음 node는 지워질 대상이다.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //지워질 대상의 slow.next에 그다음에 있는 노드로 채워주면 자연스럽게 제거됨
        slow.next = slow.next.next;
        return dummy.next;
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
