package programmers.hjh_study.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level1.ColaSolution;

import static org.assertj.core.api.Assertions.assertThat;

class ColaSolutionTest {

    private ColaSolution colaSolution;

    @BeforeEach
    void init() { colaSolution = new ColaSolution(); }

    @DisplayName("[1회차 - LEVEL1] 코카콜라 문제 테스트 [동휘]")
    @Test
    void myColaSolutionTest() {

        //given
        int a = 3;
        int b = 1;
        int n = 20;

        //when
        int answer = colaSolution.myColaSolutionTest(a, b, n);

        //then
        assertThat(answer).isEqualTo(9);
    }



}