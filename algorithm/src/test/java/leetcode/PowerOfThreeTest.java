package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PowerOfThreeTest {

    private PowerOfThree powerOfThree;

    @BeforeEach
    void init() {
        powerOfThree = new PowerOfThree();
    }

    @DisplayName("[리트코드] Power of Three")
    @Test
    void solutionTest() {
        //given
        int question1 = 27;
        int question2 = 0;
        int question3 = 45;
        int question4 = 81;

        //when
        boolean answer1 = powerOfThree.mySolution(question1);
        boolean answer2 = powerOfThree.mySolution(question2);
        boolean answer3 = powerOfThree.mySolution(question3);
        boolean answer4 = powerOfThree.mySolution(question4);

        //then
        assertThat(answer1).isTrue();
        assertThat(answer2).isFalse();
        assertThat(answer3).isFalse();
        assertThat(answer4).isTrue();

    }

}