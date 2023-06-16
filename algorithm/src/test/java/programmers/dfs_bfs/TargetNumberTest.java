package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TargetNumberTest {

    private TargetNumber targetNumber;

    @BeforeEach
    void init() {
        targetNumber = new TargetNumber();
    }

    @Test
    void targetNumber_Test() {
        //given
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = targetNumber.solution(numbers, target);
        assertThat(answer).isEqualTo(5);
    }

}