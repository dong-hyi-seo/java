package programmers.stack_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HateTheSameNumberTest {

    private HateTheSameNumber hateTheSameNumber;

    @BeforeEach
    void init() {
        hateTheSameNumber = new HateTheSameNumber();
    }

    @Test
    void hateTheSameNumber_Test1() {
        //given
        int[] arr = {1,1,3,3,0,1,1};

        //when
        int[] answer = hateTheSameNumber.solution(arr);
        int[] expected = {1,3,0,1};

        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void hateTheSameNumber_Test2() {
        //given
        int[] arr = {4,4,4,3,3};

        //when
        int[] answer = hateTheSameNumber.solution(arr);
        int[] expected = {4, 3};

        assertThat(answer).isEqualTo(expected);
    }

}