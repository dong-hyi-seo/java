package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameMapTest {

    private GameMap gameMap;

    @BeforeEach
    void init() {
        gameMap = new GameMap();
    }

    @Test
    void gameMap_Test() {
        //given
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        //when
        int answer = gameMap.solution(maps);

        //then
        assertThat(answer).isEqualTo(11);
    }

    @Test
    void gameMap_Test1() {
        //given
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        //when
        int answer = gameMap.solution(maps);

        //then
        assertThat(answer).isEqualTo(-1);
    }

}