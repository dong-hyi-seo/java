package leetcode.leetcode75.day3;

import leetcode.PartitionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    private RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList;

    @BeforeEach
    void init() {
        removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
    }

    @Test
    void removeNthNodeFromEndOfList_Test() {
        //given
        int[] arr = {1,2,3,4,5};
        RemoveNthNodeFromEndOfList.ListNode head = createNode(arr);
        int n = 2;
        //when
        RemoveNthNodeFromEndOfList.ListNode answer = removeNthNodeFromEndOfList.removeNthFromEnd(head, n);

        //then
        RemoveNthNodeFromEndOfList.ListNode expected = createNode(new int[]{1,2,3,5});
        assertThat(answer).isEqualTo(expected);
    }

    private RemoveNthNodeFromEndOfList.ListNode createNode(int[] arr) {
        RemoveNthNodeFromEndOfList.ListNode node1 = new RemoveNthNodeFromEndOfList.ListNode(0);
        RemoveNthNodeFromEndOfList.ListNode l1 = node1;
        for (int num : arr) {
            node1.next = new RemoveNthNodeFromEndOfList.ListNode(num);
            node1 = node1.next;
        }
        return l1.next;
    }
}