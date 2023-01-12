package programmers.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockExamSolutionTest {

    private MockExamSolution mockExamSolution;

    @BeforeEach
    void init() {
        mockExamSolution = new MockExamSolution();
    }

    @Test
    void mySolution_Test() {

        int[] question1 = {1, 2, 3, 4, 5};
        int[] question2 = {1, 3, 2, 4, 2};

        int[] answer1 = mockExamSolution.mySolution(question1);
        int[] answer2 = mockExamSolution.mySolution(question2);

        int[] result1 = {1};
        int[] result2 = {1, 2, 3};

        Assertions.assertThat(answer1).isEqualTo(result1);
        Assertions.assertThat(answer2).isEqualTo(result2);
    }
}