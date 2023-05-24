package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarpetTest {

    private Carpet carpet;

    @BeforeEach
    void init() {
        carpet = new Carpet();
    }

    @Test
    void carpet_Test1() {
        int brown = 10;
        int yellow = 2;

        int[] answer = carpet.solution(brown, yellow);
        int[] expectedAnswer = {4, 3};
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void carpet_Test2() {
        int brown = 8;
        int yellow = 1;

        int[] answer = carpet.solution(brown, yellow);
        int[] expectedAnswer = {3, 3};
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void carpet_Test3() {
        int brown = 24;
        int yellow = 24;

        int[] answer = carpet.solution(brown, yellow);
        int[] expectedAnswer = {8, 6};
        assertThat(answer).isEqualTo(expectedAnswer);
    }
}