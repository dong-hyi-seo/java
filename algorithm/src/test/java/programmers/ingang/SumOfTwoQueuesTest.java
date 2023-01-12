package programmers.ingang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.ingang.SumOfTwoQueues;

import static org.assertj.core.api.Assertions.*;

class SumOfTwoQueuesTest {

    private SumOfTwoQueues sumOfTwoQueues;

    @BeforeEach
    void init() {
        sumOfTwoQueues = new SumOfTwoQueues();
    }

    @DisplayName("두 큐 합 같게 만들기")
    @Test
    void mySolutionTest() {
        //given
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        //when
        int answer = sumOfTwoQueues.mySolution(queue1, queue2);

        //then
        assertThat(answer).isEqualTo(2);
    }
}