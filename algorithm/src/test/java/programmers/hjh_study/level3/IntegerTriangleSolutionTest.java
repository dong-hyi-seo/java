package programmers.hjh_study.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level3.IntegerTriangleSolution;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerTriangleSolutionTest {

    private IntegerTriangleSolution solution;

    @BeforeEach
    void init() {
        solution = new IntegerTriangleSolution();
    }

    @DisplayName("[4회차 - LEVEL3] 정수삼각형")
    @Test
    void mySolution_Test() {

        //given
        int [][] question = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        //when
        int answer = solution.mySolution(question);

        //then
        assertThat(answer).isEqualTo(30);


    }
}