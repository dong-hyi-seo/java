package programmers.sort;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class MostBigNumberTest {

    private MostBigNumber mostBigNumber;

    @BeforeEach
    void init() {
        mostBigNumber = new MostBigNumber();
    }

    @Test
    void mostBigNumber_Test1() {
        int[] numbers = {6, 10 ,2};

        String answer = mostBigNumber.solution(numbers);

        assertThat(answer).isEqualTo("6210");
    }

    @Test
    void mostBigNumber_Test2() {
        int[] numbers = {3, 30, 34, 5, 9};

        String answer = mostBigNumber.solution(numbers);

        assertThat(answer).isEqualTo("9534330");
    }
}