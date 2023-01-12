package leetcode;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void init() {
        twoSum = new TwoSum();
    }

    @DisplayName("[리트코드] Two Sum")
    @Test
    void mySolutionTest() {
        //given
        int[] questionNums1 = {2, 7, 11, 15};
        int questionTarget1 = 9;

        int[] questionNums2 = {3, 2, 4};
        int questionTarget2 = 6;

        //when
        int[] answer1 = twoSum.mySolution(questionNums1, questionTarget1);
        int[] answer2 = twoSum.mySolution(questionNums2, questionTarget2);
        int[] anotherSolution1 = twoSum.anotherSolution(questionNums1, questionTarget1);
        int[] anotherSolution2 = twoSum.anotherSolution(questionNums2, questionTarget2);

        //then
        int[] expectAnswer1 = {0, 1};
        int[] expectAnswer2 = {1, 2};
        assertThat(answer1).isEqualTo(expectAnswer1);
        assertThat(answer2).isEqualTo(expectAnswer2);

        assertThat(anotherSolution1).isEqualTo(expectAnswer1);
        assertThat(anotherSolution2).isEqualTo(expectAnswer2);


    }
}