package leetcode.leetcode75.day1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class WhereWillTheBallFallTest {

    private WhereWillTheBallFall whereWillTheBallFall;

    @BeforeEach
    void init() {
        whereWillTheBallFall = new WhereWillTheBallFall();
    }

    @Test
    void whereWillTheBallFall_Test1() {
        //given
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};

        //when
        int[] answer = whereWillTheBallFall.findBall(grid);

        //then
        int[] expected = {1, -1, -1, -1 ,-1};
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void whereWillTheBallFall_Test2() {
        int[][] grid = {{-1}};

        //when
        int[] answer = whereWillTheBallFall.findBall(grid);

        //then
        int[] expected = {-1};
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void whereWillTheBallFall_Test3() {
        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};

        //when
        int[] answer = whereWillTheBallFall.findBall(grid);

        //then
        int[] expected = {0,1,2,3,4,-1};
        assertThat(answer).isEqualTo(expected);
    }
}