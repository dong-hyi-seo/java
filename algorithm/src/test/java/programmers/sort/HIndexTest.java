package programmers.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HIndexTest {

    private HIndex hIndex;

    @BeforeEach
    void init() {
        hIndex = new HIndex();
    }

    @Test
    void hIndex_Test1() {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = hIndex.solution(citations);
        int expectedAnswer = 3;
        assertThat(answer).isEqualTo(expectedAnswer);
    }
}