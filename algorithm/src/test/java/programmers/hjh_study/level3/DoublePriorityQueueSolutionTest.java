package programmers.hjh_study.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.level3.DoublePriorityQueueSolution;

import static org.assertj.core.api.Assertions.assertThat;

class DoublePriorityQueueSolutionTest {

    private DoublePriorityQueueSolution solution;

    @BeforeEach
    void init() {
        solution = new DoublePriorityQueueSolution();
    }

    @DisplayName("[3회차 - LEVEL3] 이중우선순위큐 테스트")
    @Test
    void mySolutionTest() {
        //given
        String [] operation1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String [] operation2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        //when
        int[] answer1 = solution.mySolution(operation1);
        int[] answer2 = solution.mySolution(operation2);

        //then
        int [] expected1 = {0,0};
        int [] expected2 = {333, -45};

        assertThat(answer1).isEqualTo(expected1);
        assertThat(answer2).isEqualTo(expected2);
    }
}