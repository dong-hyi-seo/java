package programmers.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoreSpicyTest {

    private MoreSpicy moreSpicy;

    @BeforeEach
    void init() {
        moreSpicy = new MoreSpicy();
    }

    @Test
    void moreSpice_Test1() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int answer = moreSpicy.solution(scoville, k);

        assertThat(answer).isEqualTo(2);
    }

    @Test
    void moreSpice_Test2() {
        int[] scoville = {1,1,2,6};
        int k = 24;

        int answer = moreSpicy.solution(scoville, k);

        assertThat(answer).isEqualTo(-1);
    }
}