package programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetNumberSolutionTest {

    private TargetNumberSolution targetNumberSolution;

    @BeforeEach
    void init() {
        targetNumberSolution = new TargetNumberSolution();
    }

    @Test
    void mySolution_Test() {

        //int [] numbers = {1, 1, 1, 1, 1};
        //int target = 3;

        int [] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        //int answer = targetNumberSolution.mySolution(numbers, target);
        int answer2 = targetNumberSolution.mySolution(numbers2, target2);

        //Assertions.assertThat(answer).isEqualTo(5);
        Assertions.assertThat(answer2).isEqualTo(2);
    }
}