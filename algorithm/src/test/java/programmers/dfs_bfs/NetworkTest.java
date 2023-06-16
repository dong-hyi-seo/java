package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NetworkTest {

    private Network network;

    @BeforeEach
    void init() {
        network = new Network();
    }

    @Test
    void network_Test() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int answer = network.solution(n, computers);

        assertThat(answer).isEqualTo(2);
    }

}