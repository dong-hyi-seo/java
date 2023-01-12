package programmers.hjh_study.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level1.HamburgerSolution;

import static org.assertj.core.api.Assertions.assertThat;

class HamburgerSolutionTest {

    HamburgerSolution hamburgerSolution;

    @BeforeEach
    void init() {
        hamburgerSolution = new HamburgerSolution();
    }

    @Test
    void test() {
        String test = "1231423";
        test = test.replaceAll("1231", "");
        System.out.println("test = " + test);
    }

    @Test
    @DisplayName("[그냥 - LEVEL1] 햄버거만들기")
    void mySolutionTest() {

        //given
        int [] question1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int [] question2 = {1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1};

        //when
        int answer1 = hamburgerSolution.mySolution(question1);
        int answer2 = hamburgerSolution.anotherSolution(question2);

        //then
        int expectedAnswer1 = 2;
        int expectedAnswer2 = 3;

        assertThat(answer1).isEqualTo(expectedAnswer1);
        assertThat(answer2).isEqualTo(expectedAnswer2);
    }

}