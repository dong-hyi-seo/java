package programmers.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MakeBigNumberTest {

    private MakeBigNumber makeBigNumber;

    @BeforeEach
    void init() {
        makeBigNumber = new MakeBigNumber();
    }

    @Test
    void makeBigNumber_Test() {
        //given
        String number = "1924";
        int k = 2;

        String answer = makeBigNumber.solution(number, k);

        assertThat(answer).isEqualTo("94");
    }

    @Test
    void makeBigNumber_Test1() {
        //given
        String number = "1231234";
        int k = 3;

        String answer = makeBigNumber.solution(number, k);

        assertThat(answer).isEqualTo("3234");
    }

}