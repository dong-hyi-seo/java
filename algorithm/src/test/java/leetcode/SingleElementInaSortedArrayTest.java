package leetcode;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class SingleElementInaSortedArrayTest {


    private SingleElementInaSortedArray singleElementInaSortedArray;
    @BeforeEach
    void init() {
        singleElementInaSortedArray = new SingleElementInaSortedArray();
    }

    @Test
    void singleElementInaSortedArray_Test() {
        //given
        //int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        //int[] nums2 = {3,3,7,7,10,11,11};
        int[] nums3 = {1,1,2,2,3,3,4};

        //when
        //int answer1 = singleElementInaSortedArray.singleNonDuplicate(nums1);
        //int answer2 = singleElementInaSortedArray.singleNonDuplicate(nums2);
        int answer3 = singleElementInaSortedArray.singleNonDuplicate(nums3);

        //then
        //assertThat(answer1).isEqualTo(2);
        //assertThat(answer2).isEqualTo(10);
        assertThat(answer3).isEqualTo(4);
    }

}