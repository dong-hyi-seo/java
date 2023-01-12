package programmers.hjh_study.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level3.Npresentation;

import static org.assertj.core.api.Assertions.assertThat;

class NpresentationTest {

    private Npresentation npresentation;

    @BeforeEach
    void init() {
        npresentation = new Npresentation();
    }

    @Test
    @DisplayName("[5회차 - LEVEL3] N으로 표현")
    void mySolution_Test() {
        //given
        int n1 = 5;
        int n2 = 2;
        int number1 = 12;
        int number2 = 11;

        //when
        int answer1 = npresentation.mySolution(n1, number1);
        int answer2 = npresentation.mySolution(n2, number2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(3);
    }
}