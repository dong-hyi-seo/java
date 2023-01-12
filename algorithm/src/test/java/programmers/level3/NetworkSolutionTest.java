package programmers.level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkSolutionTest {

    private NetworkSolution networkSolution;

    @BeforeEach
    void init() {
        networkSolution = new NetworkSolution();
    }

    @Test
    void mySolution_Test() {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        int n1 = 3;
        int[][] computers1 = {{1,1,0}, {1,1,1}, {0,1,1}};

        int n2 = 6;
        int[][] computers2 = {
                {1, 1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
        };

        int answer = networkSolution.mySolution(n, computers);
        int answer1 = networkSolution.mySolution(n1, computers1);
        int answer2 = networkSolution.mySolution(n2, computers2);

        Assertions.assertThat(answer).isEqualTo(2);
        Assertions.assertThat(answer1).isEqualTo(1);
        Assertions.assertThat(answer2).isEqualTo(3);
    }
}