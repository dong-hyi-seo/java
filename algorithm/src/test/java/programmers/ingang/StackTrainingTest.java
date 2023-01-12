package programmers.ingang;

import programmers.ingang.StackTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StackTrainingTest {

    private StackTraining stackTraining;

    @BeforeEach
    void init() {
        stackTraining = new StackTraining();
    }

    @DisplayName("[Stack] 괄호문제")
    @Test
    void bracketMySolutionTest() {
        //given
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        //when
        boolean answer1 = stackTraining.bracketMySolution(s1);
        boolean answer2 = stackTraining.bracketMySolution(s2);
        boolean answer3 = stackTraining.bracketMySolution(s3);
        boolean answer4 = stackTraining.bracketMySolution(s4);

        //then
        assertThat(answer1).isTrue();
        assertThat(answer2).isTrue();
        assertThat(answer3).isFalse();
        assertThat(answer4).isFalse();
    }

    @DisplayName("[Stack] 주식가격 알고리즘")
    @Test
    void stockMySolutionTest() {
        //given
        int[] prices = {1, 2, 3, 2, 3};

        //when
        int[] answer = stackTraining.stockMySolution(prices);
        int[] anotherAnswer = stackTraining.stockAnotherSolution(prices);


        //then
        int[] expactAnswer = {4, 3, 1, 1, 0};
        assertThat(answer).isEqualTo(expactAnswer);
        assertThat(anotherAnswer).isEqualTo(expactAnswer);
    }
}