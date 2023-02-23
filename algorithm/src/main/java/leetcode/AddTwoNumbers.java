package leetcode;

import java.util.Objects;

/**
 * @since 2023.02.23
 * URL : https://leetcode.com/problems/add-two-numbers/
 * 두 개의 음수 가 아닌 정수를 나타내는 두 개의 비어 있지 않은 연결 목록이 제공됩니다.
 * 숫자는 역순 으로 저장되며 각 노드에는 단일 숫자가 포함됩니다. 두 숫자를 더하고 합계를 연결 리스트로 반환합니다.
 * 숫자 0 자체를 제외하고 두 숫자에 선행 0이 포함되어 있지 않다고 가정할 수 있습니다.
 *
 * 예1)
 * 입력: l1 = [2,4,3], l2 = [5,6,4]
 * 출력: [7,0,8]
 * 설명: 342 + 465 = 807
 *
 * 예2)
 * 입력: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 출력: [8,9,9,9,0,0,0,1]
 *
 * 제약
 * 각 연결 목록의 노드 수는 범위에 있습니다 [1, 100].
 * 0 <= Node.val <= 9
 * 목록이 선행 0이 없는 숫자를 나타내는 것이 보장됩니다.
 */
public class AddTwoNumbers {

    /**
     * 1. l1, l2 연결리스트의 각 index에 해당하는 값들에 대해서 두개 더한다.
     * 2.
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0); //연산결과를 저장할 리스트하나
        ListNode result = node; //최초의 노드
        int sum = 0;
        //sum > 0 해당조건은 l1, l2 다음노드가 더이상 없어도 더한값이 10보다 크면 1의 자리가 생성가능하기떄문에 sum값도 체크해야함
        while (l1 != null || l2 != null || sum > 0 ) {
            System.out.println("=================");
            System.out.println("l1 = " + l1);
            System.out.println("l2 = " + l2);
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            System.out.println("sum = " + sum);
            //두개 l1, l2 같은 위치의 값을 더해서 10을 나눈 나머지를 node로 할당
            node.next = new ListNode(sum % 10);
            System.out.println("node next = " + node.next);

            //위 l1,l2 더한값에서 10 나눈 몫을 그다음 노드에 반영하기위해 sum 변수값에 남겨둔다
            sum /= 10;
            node = node.next; //node값은 초기화
            System.out.println("node = " + node);
            System.out.println("result = " + result);
        }
        System.out.println("result node = " + node);
        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}



