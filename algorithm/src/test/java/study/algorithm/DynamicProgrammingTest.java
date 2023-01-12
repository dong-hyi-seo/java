package study.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DynamicProgrammingTest {

    DynamicProgramming dynamicProgramming;

    @BeforeEach
    void init() {
        dynamicProgramming = new DynamicProgramming();
    }

    @Test
    @DisplayName("동적계획법 공부 - 일반적인 피보나치 수열 재귀")
    void fibonacciNormal_Test() {

        //given
        int n = 10;

        //when
        long answer = dynamicProgramming.fibonacciNormal(n);
        System.out.println("answer = " + answer);

        //then
        assertThat(answer).isEqualTo(55);


    }

    @Test
    @DisplayName("동적계획법 공부 - 피보나치 수열 Top Down (DP)")
    void fibonacciTopDownDp_Test() {
        //given
        int n = 100;

        //when
        long answer = dynamicProgramming.fibonacciTopDownDpRun(n);
        System.out.println("answer = " + answer);

        //then
        assertThat(answer).isEqualTo(3736710778780434371L);
    }

    @Test
    @DisplayName("동적계획법 공부 - 피보나치 수열 Bottom Up (DP)")
    void fibonacciBottomUpDp_Test() {
//given
        int n = 100;

        //when
        long answer = dynamicProgramming.fibonacciBottomUpDpRun(n);
        System.out.println("answer = " + answer);

        //then
        assertThat(answer).isEqualTo(3736710778780434371L);
    }
}