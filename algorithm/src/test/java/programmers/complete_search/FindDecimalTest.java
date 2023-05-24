package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FindDecimalTest {

    private FindDecimal findDecimal;

    @BeforeEach
    void init() {
        findDecimal = new FindDecimal();
    }

    @Test
    void findDecimal_Test1() {
        final String numbers = "17";

        int answer = findDecimal.solution(numbers);

        assertThat(answer).isEqualTo(3);
    }

    @Test
    void findDecimal_Test2() {
        final String numbers = "1231";

        int answer = findDecimal.solution(numbers);

        assertThat(answer).isEqualTo(18);
    }
}