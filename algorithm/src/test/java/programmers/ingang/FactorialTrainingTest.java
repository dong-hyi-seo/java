package programmers.ingang;

import programmers.ingang.FactorialTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FactorialTrainingTest {

    private FactorialTraining factorialTraining;

    @BeforeEach
    void init() {
        factorialTraining = new FactorialTraining();
    }

    @DisplayName("팩토리얼 알고리즘 (재귀)")
    @Test
    void factorialMySolutionTest() {
        //given
        int question = 5;

        //when
        int answer = factorialTraining.factorialMySolution(question);

        //then
        assertThat(answer).isEqualTo(120);
    }


}