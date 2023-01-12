package programmers.ingang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.ingang.StringCompression;

import static org.assertj.core.api.Assertions.*;

class StringCompressionTest {

    private StringCompression stringCompression;

    @BeforeEach
    void init() {
        stringCompression = new StringCompression();
    }

    @DisplayName("[프로그래머스] 문자열 압축")
    @Test
    void mySolutionTest() {
        //given
        String question1 = "aabbaccc";
        String question2 = "ababcdcdababcdcd";
        String question3 = "abcabcdede";
        String question4 = "abcabcabcabcdededededede";
        String question5 = "xababcdcdababcdcd";

        //when
        int answer1 = stringCompression.mySolution(question1);
        //int answer2 = stringCompression.mySolution(question2);
        //int answer3 = stringCompression.mySolution(question3);
        //int answer4 = stringCompression.mySolution(question4);
        //int answer5 = stringCompression.mySolution(question5);

        //then
        assertThat(answer1).isEqualTo(7);
        //assertThat(answer2).isEqualTo(9);
        //assertThat(answer3).isEqualTo(8);
        //assertThat(answer4).isEqualTo(14);
        //assertThat(answer5).isEqualTo(17);
    }
}