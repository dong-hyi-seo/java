package programmers.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PocketMonTest {

    private PocketMon pocketMon;

    @BeforeEach
    void init() {
        pocketMon = new PocketMon();
    }

    @Test
    void pocketMon_Test() {
        //given
        int[] nums = {3, 1, 2, 3};

        //when
        int answer = pocketMon.solution(nums);
        int expectedAnswer = 2;

        Assertions.assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void pocketMon_Test2() {
        //given
        int[] nums = {3, 3, 3, 2, 2, 4};

        //when
        int answer = pocketMon.solution(nums);
        int expectedAnswer = 3;

        Assertions.assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void pocketMon_Test3() {
        //given
        int[] nums = {3, 3, 3, 2, 2, 2};

        //when
        int answer = pocketMon.solution(nums);
        int expectedAnswer = 2;

        Assertions.assertThat(answer).isEqualTo(expectedAnswer);
    }
}