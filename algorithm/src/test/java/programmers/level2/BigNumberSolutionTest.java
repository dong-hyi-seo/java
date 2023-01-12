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
        int[] numbers = {0, 0, 1};
        int[] numbers2 = {3, 30, 34, 9, 5};
        int[] numbers3 = {104, 1};
        int[] numbers4 = {979, 97, 978, 81, 818, 817};

        String answer = bigNumberSolution.anotherSolution(numbers);
        String answer2 = bigNumberSolution.anotherSolution(numbers2);
        String answer3 = bigNumberSolution.anotherSolution(numbers3);
        String answer4 = bigNumberSolution.anotherSolution(numbers4);

        Assertions.assertThat(answer).isEqualTo("100");
        Assertions.assertThat(answer2).isEqualTo("9534330");
        Assertions.assertThat(answer3).isEqualTo("1104");
        Assertions.assertThat(answer4).isEqualTo("9799797881881817");
    }
}