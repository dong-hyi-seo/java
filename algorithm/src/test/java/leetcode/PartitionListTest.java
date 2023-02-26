package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
class PartitionListTest {

    private PartitionList partitionList;

    @BeforeEach
    void init() {
        partitionList = new PartitionList();
    }

    @Test
    void partitionList_Test() {

        //given
        int[] arr = {1,4,3,2,5,2};
        int partition = 3;

        //when
        PartitionList.ListNode answer = partitionList.partition(createNode(arr), partition);

        //then
        int[] expectedArr = {1,2,2,4,3,5};
        PartitionList.ListNode expected = createNode(expectedArr);

        assertThat(answer).isEqualTo(expected);

    }

    private PartitionList.ListNode createNode(int[] arr) {
        PartitionList.ListNode node1 = new PartitionList.ListNode(0);
        PartitionList.ListNode l1 = node1;
        for (int num : arr) {
            node1.next = new PartitionList.ListNode(num);
            node1 = node1.next;
        }
        return l1.next;
    }
}