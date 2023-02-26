package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
class LinkedListCycle2Test {
    private LinkedListCycle2 linkedListCycle2;

    @BeforeEach
    void init() {
        linkedListCycle2 = new LinkedListCycle2();
    }

    @Test
    void linkedListCycle2_Test() {
        //given
        LinkedListCycle2.ListNode firstNode = new LinkedListCycle2.ListNode(3);
        firstNode.next = new LinkedListCycle2.ListNode(2);
        firstNode.next.next = new LinkedListCycle2.ListNode(0);
        firstNode.next.next.next = new LinkedListCycle2.ListNode(-4);
        firstNode.next.next.next.next = firstNode.next;

        //when
        LinkedListCycle2.ListNode answer = linkedListCycle2.detectCycle(firstNode);

        //then
        LinkedListCycle2.ListNode expected = firstNode.next.next.next;
        assertThat(answer).isEqualTo(expected);
    }
}