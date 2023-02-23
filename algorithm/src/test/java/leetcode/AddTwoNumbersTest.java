package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AddTwoNumbersTest {

    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    void init() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    void addTwoNumbers_Test() {
        //given
        int [] nums1 = {2,4,3};
        int [] nums2 = {5,6,4};
        AddTwoNumbers.ListNode l1 = createNode(nums1);
        AddTwoNumbers.ListNode l2 = createNode(nums2);

        //when
        AddTwoNumbers.ListNode answer = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println("answer = " + answer);

        //then
        int[] expectedArr = {7,0,8};
        AddTwoNumbers.ListNode expected = createNode(expectedArr);
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void addTwoNumbers_Another_Test() {
        int[] nums1 = {9,9,9,9,9,9,9};
        int[] nums2 = {9,9,9,9};
        AddTwoNumbers.ListNode l1 = createNode(nums1);
        AddTwoNumbers.ListNode l2 = createNode(nums2);

        //when
        AddTwoNumbers.ListNode answer = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println("answer = " + answer);

        //then
        int[] expectedArr = {8,9,9,9,0,0,0,1};
        AddTwoNumbers.ListNode expected = createNode(expectedArr);
        assertThat(answer).isEqualTo(expected);

    }

    private AddTwoNumbers.ListNode createNode(int[] arr) {
        AddTwoNumbers.ListNode node1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode l1 = node1;
        for (int num : arr) {
            node1.next = new AddTwoNumbers.ListNode(num);
            node1 = node1.next;
        }
        return l1.next;
    }
}