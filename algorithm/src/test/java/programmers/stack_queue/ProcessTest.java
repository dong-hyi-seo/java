package programmers.stack_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProcessTest {

    private Process process;

    @BeforeEach
    void init() {
        process = new Process();
    }

    @Test
    void process_Test1() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int answer = process.solution(priorities, location);
        int expectedAnswer = 1;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void process_Test2() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = process.solution(priorities, location);
        int expectedAnswer = 5;

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}