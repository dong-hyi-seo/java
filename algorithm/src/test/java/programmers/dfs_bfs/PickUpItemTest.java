package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PickUpItemTest {

    private PickUpItem pickUpItem;

    @BeforeEach
    void init() {
        pickUpItem = new PickUpItem();
    }

    @Test
    void pickUpItem_Test1() {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        int answer = pickUpItem.solution(rectangle, characterX, characterY, itemX, itemY);

        assertThat(answer).isEqualTo(17);
    }

    @Test
    void pickUpItem_Test2() {

    }

}