package programmers.hjh_study.level2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level2.JadenCaseStringsSolution;

import static org.assertj.core.api.Assertions.assertThat;

class JadenCaseStringsSolutionTest {

    private JadenCaseStringsSolution solution;

    @BeforeEach
    void init() {
        solution = new JadenCaseStringsSolution();
    }

    @DisplayName("[4회차 - LEVEL2] JadenCase 문자열 만들기")
    @Test
    void mySolution_Test() {
        //given
        String question = "3people unFollowed me";
        String question1 = "  3people  unFollowed me  ";


        //when
        String answer = solution.mySolution(question);
        String answer1 = solution.mySolution(question1);
        String anotherAnswer = solution.anotherSolution(question);
        String anotherAnswer1 = solution.anotherSolution(question1);

        //then
        String expected = "3people Unfollowed Me";
        String expected1 = "  3people  Unfollowed Me  ";
        assertThat(answer).isEqualTo(expected);
        assertThat(anotherAnswer).isEqualTo(expected);
        assertThat(anotherAnswer1).isEqualTo(expected1);
    }
}