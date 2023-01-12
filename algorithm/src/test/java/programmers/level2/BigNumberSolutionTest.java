package programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberSolutionTest {

    private BigNumberSolution bigNumberSolution;

    @BeforeEach
    void init() {
        bigNumberSolution = new BigNumberSolution();
    }

    @Test
    void mySolution_Test() {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        String answer = bigNumberSolution.mySolution(numbers);
        String answer2 = bigNumberSolution.mySolution(numbers2);

        Assertions.assertThat(answer).isEqualTo("6210");
        Assertions.assertThat(answer2).isEqualTo("9534330");
    }
}