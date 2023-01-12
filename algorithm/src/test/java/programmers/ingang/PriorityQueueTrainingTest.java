package programmers.ingang;

import programmers.ingang.PriorityQueueTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PriorityQueueTrainingTest {

    private PriorityQueueTraining priorityQueueTraining;

    @BeforeEach
    void init() {
        priorityQueueTraining = new PriorityQueueTraining();
    }

    @DisplayName("[PriorityQueue] 우선순위 큐 프린터 알고리즘 테스트")
    @Test
    void printerMySolution() {
        //given
        int[] priorities = {2, 3, 5, 1};
        int location = 2;

        //when
        int answer = priorityQueueTraining.printerMySolution(priorities, location);
        int anotherAnswer = priorityQueueTraining.printerAnotherSolution(priorities, location);

        //then
        assertThat(answer).isEqualTo(5);
        assertThat(anotherAnswer).isEqualTo(5);
    }

}