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
        int[] nums = {1, 7, 3, 6, 5, 6};

        int answer = findPivotIndex.solution(nums);
        int expectedAnswer = 3;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void findPivotIndex_Test2() {
        //given
        int[] nums = {2, 1, -1};

        int answer = findPivotIndex.solution(nums);
        int expectedAnswer = 0;

        assertThat(answer).isEqualTo(expectedAnswer);
    }


}