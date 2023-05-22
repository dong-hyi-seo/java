package programmers.sort;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class KnumberTest {

    private Knumber knumber;

    @BeforeEach
    void init() {
        knumber = new Knumber();
    }

    @Test
    void kNumber_Test1() {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = knumber.solution(array, commands);
        int[] expectedAnswer = {5, 6, 3};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}