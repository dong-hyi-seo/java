package leetcode.leetcode75.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
class MultiplyStringsTest {

    private MultiplyStrings multiplyStrings;

    @BeforeEach
    void init() {
        multiplyStrings = new MultiplyStrings();
    }

    @Test
    void multiplyStrings_Test() {
        //given
        String num1 = "123";
        String num2 = "456";

        //when
        String answer = multiplyStrings.multiply(num1, num2);

        //then
        assertThat(answer).isEqualTo("56088");
    }

}