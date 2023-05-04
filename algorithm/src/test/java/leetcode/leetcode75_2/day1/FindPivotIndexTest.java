package leetcode.leetcode75_2.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FindPivotIndexTest {

    private FindPivotIndex findPivotIndex;

    @BeforeEach
    void init() {
        findPivotIndex = new FindPivotIndex();
    }

    @Test
    void findPivotIndex_Test() {
        //given
        int[] nums = {1, 2, 3, 4};

        //when
        int[] answer = findPivotIndex.solution(nums);

        //then
        int[] expectedAnswer = {1, 3, 6, 10};
        assertThat(answer).isEqualTo(expectedAnswer);
    }
}