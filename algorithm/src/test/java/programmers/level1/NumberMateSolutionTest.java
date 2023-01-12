package programmers.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberMateSolutionTest {

    private NumberMateSolution numberMateSolution;

    @BeforeEach
    void init() {
        numberMateSolution = new NumberMateSolution();
    }

    @Test
    void mySolution_Test() {

        String x = "1000000002";
        String y = "20200";

        String answer = numberMateSolution.solution(x, y);

        Assertions.assertThat(answer).isEqualTo("2000");
    }

}