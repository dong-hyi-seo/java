package leetcode.leetcode75_2.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunningSumOf1dArrayTest {

    private RunningSumOf1dArray runningSumOf1dArray;

    @BeforeEach
    void init() {
        runningSumOf1dArray = new RunningSumOf1dArray();
    }

    @Test
    void runningSumOf1dArray_Test() {
        //given
        int[] nums = {1, 2, 3, 4};

        //when
        int[] answer = runningSumOf1dArray.solution(nums);

        //then
        int[] expectedAnswer = {1, 3, 6, 10};
        assertThat(answer).isEqualTo(expectedAnswer);
    }

}