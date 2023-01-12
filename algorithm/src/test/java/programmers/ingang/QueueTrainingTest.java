package programmers.ingang;

import programmers.ingang.QueueTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class QueueTrainingTest {

    private QueueTraining queueTraining;

    @BeforeEach
    void init() {
        queueTraining = new QueueTraining();
    }

    @DisplayName("[Queue] 기능개발 알고리즘")
    @Test
    void developmentSolutionTest() {
        //given
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        //when
        int[] answer = queueTraining.developmentSolution(progresses1, speeds1);

        //then
        int[] expectAnswer = {2,1};
        assertThat(answer).isEqualTo(expectAnswer);
    }

}