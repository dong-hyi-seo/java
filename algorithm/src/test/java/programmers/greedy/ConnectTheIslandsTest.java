package programmers.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.kruskal.ConnectTheIslands;

import static org.assertj.core.api.Assertions.*;

class ConnectTheIslandsTest {

    private ConnectTheIslands connectTheIslands;

    @BeforeEach
    void init() {
        connectTheIslands = new ConnectTheIslands();
    }

    @Test
    void connectTheIslands_Test() {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer = connectTheIslands.solution(n, costs);

        assertThat(answer).isEqualTo(4);
    }

}