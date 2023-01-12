package programmers.hjh_study.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level3.MaxMinSolution;

import static org.assertj.core.api.Assertions.assertThat;

class MaxMinSolutionTest {

    MaxMinSolution maxMinSolution;

    @BeforeEach
    void init() {
        maxMinSolution = new MaxMinSolution();
    }

    @Test
    @DisplayName("[3회차 - LEVEL2] 최댓값과 최솟값 [동휘]")
    void mySolution_Test() {
        //given
        String s = "-1 -2 -3 -4";

        //when
        String answer = maxMinSolution.mySolution(s);

        //then
        assertThat(answer).isEqualTo("-4 -1");
    }

}