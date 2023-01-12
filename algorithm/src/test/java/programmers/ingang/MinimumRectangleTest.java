package programmers.ingang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.ingang.MinimumRectangle;

import static org.assertj.core.api.Assertions.*;

class MinimumRectangleTest {

    private MinimumRectangle minimumRectangle;

    @BeforeEach
    void init() {
        minimumRectangle = new MinimumRectangle();
    }

    @DisplayName("최소직사각형 - 완전탐색")
    @Test
    void mySolutionTest() {
        //given
        int[][] sizes1 = {
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        };
        int[][] sizes2 = {
                {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
        };
        int[][] sizes3 = {
                {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
        };

        //when mySolution (for * 3) 보다 another solution (for문 한번만돔) 이 더빠름
        int answer1 = minimumRectangle.mySolution(sizes1);
        int answer2 = minimumRectangle.mySolution(sizes2);
        int answer3 = minimumRectangle.mySolution(sizes3);

        int anotherAnswer1 = minimumRectangle.anotherSolution(sizes1);
        int anotherAnswer2 = minimumRectangle.anotherSolution(sizes2);
        int anotherAnswer3 = minimumRectangle.anotherSolution(sizes3);

        //then
        assertThat(answer1).isEqualTo(4000);
        assertThat(answer2).isEqualTo(120);
        assertThat(answer3).isEqualTo(133);

        assertThat(anotherAnswer1).isEqualTo(4000);
        assertThat(anotherAnswer2).isEqualTo(120);
        assertThat(anotherAnswer3).isEqualTo(133);

    }
}