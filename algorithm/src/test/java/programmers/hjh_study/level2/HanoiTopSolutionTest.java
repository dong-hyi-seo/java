package programmers.hjh_study.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level2.HanoiTopSolution;

import static org.assertj.core.api.Assertions.assertThat;
class HanoiTopSolutionTest {

    HanoiTopSolution hanoiTopSolution;

    @BeforeEach
    void init() {
        hanoiTopSolution = new HanoiTopSolution();
    }

    @DisplayName("[2회차 - LEVEL3] 하노이의 탑 [동휘]")
    @Test
    void myHanoiTopSolutionTest() {
        //given
        int n = 2;

        int[][] answer = hanoiTopSolution.mySolution(n);

        //expected
        int[][] result = { {1,2}, {1,3}, {2,3} };
        assertThat(answer).isEqualTo(result);
    }

}