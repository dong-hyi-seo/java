package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class LinkedListCycleTest {

    private LinkedListCycle linkedListCycle;

    @BeforeEach
    void init() {
        linkedListCycle = new LinkedListCycle();
    }

    /**
     * 입력: head = [3,2,0,-4], pos = 1
     * 출력: true
     * 설명: 연결 목록에는 꼬리가 첫 번째 노드(인덱스 0)에 연결되는 주기가 있습니다.
     */
    @Test
    void linkedListCycle_Test() {
        //given
        LinkedListCycle.ListNode firstNode = new LinkedListCycle.ListNode(3);
        firstNode.next = new LinkedListCycle.ListNode(2);
        firstNode.next.next = new LinkedListCycle.ListNode(0);
        firstNode.next.next.next = new LinkedListCycle.ListNode(-4);
        firstNode.next.next.next.next = firstNode.next;

        //when
        boolean answer = linkedListCycle.hasCycle(firstNode);

        //then
        assertThat(answer).isTrue();
    }

}