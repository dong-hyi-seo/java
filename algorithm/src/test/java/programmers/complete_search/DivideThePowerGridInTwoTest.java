package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DivideThePowerGridInTwoTest {

    private DivideThePowerGridInTwo divideThePowerGridInTwo;

    @BeforeEach
    void init() {
        divideThePowerGridInTwo = new DivideThePowerGridInTwo();
    }

    @Test
    void divideThePowerGridInTwo_Test1() {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int answer = divideThePowerGridInTwo.solution(n , wires);
        int expectedAnswer = 3;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void divideThePowerGridInTwo_Test2() {
        int n = 4;
        int[][] wires = {{1,2},{2,3},{3,4}};

        int answer = divideThePowerGridInTwo.solution(n , wires);
        int expectedAnswer = 0;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void divideThePowerGridInTwo_Test3() {
        int n = 7;
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int answer = divideThePowerGridInTwo.solution(n , wires);
        int expectedAnswer = 1;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}