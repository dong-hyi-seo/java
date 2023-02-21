package leetcode.leetcode75.day1;

import leetcode.leetcode75.day1.HappyNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HappyNumberTest {

    private HappyNumber happyNumber;

    @BeforeEach
    void init() {
        happyNumber = new HappyNumber();
    }

    @Test
    void happyNumber_Test() {
        //given
        int n = 19;

        //when
        boolean answer = happyNumber.isHappy(n);

        //then
        assertThat(answer).isTrue();
    }

}