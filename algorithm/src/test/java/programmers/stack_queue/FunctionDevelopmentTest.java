package programmers.stack_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
class FunctionDevelopmentTest {

    private FunctionDevelopment functionDevelopment;

    @BeforeEach
    void init() {
        functionDevelopment = new FunctionDevelopment();
    }

    @Test
    void functionDevelopment_Test1() {
        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = functionDevelopment.solution(progress, speeds);
        int[] expectedAnswer = {2, 1};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void functionDevelopment_Test2() {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = functionDevelopment.solution(progress, speeds);
        int[] expectedAnswer = {1, 3, 2};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}