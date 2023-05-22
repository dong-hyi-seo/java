package programmers.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DiskControllerTest {

    private DiskController diskController;

    @BeforeEach
    void init () {
        diskController = new DiskController();
    }

    @Test
    void disController_Test1() {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int answer = diskController.solution(jobs);

        assertThat(answer).isEqualTo(9);

    }

}