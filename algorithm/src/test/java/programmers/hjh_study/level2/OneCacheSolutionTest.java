package programmers.hjh_study.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level2.OneCacheSolution;

import static org.assertj.core.api.Assertions.assertThat;

class OneCacheSolutionTest {
    private OneCacheSolution oneCacheSolution;

    @BeforeEach
    void init() { oneCacheSolution = new OneCacheSolution();}

    @DisplayName("[1회차 - LEVEL2] 1차캐시 문제 변형 테스트 [동휘]")
    @Test
    void myOneCacheSolutionTest() {
        //given
        final int cacheSize = 2;
        final String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        //when
        int answer = oneCacheSolution.myOneCacheSolution(cacheSize, cities);

        //then
        assertThat(answer).isEqualTo(16);
    }
}