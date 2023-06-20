package programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RotateMatrixBordersTest {

    private RotateMatrixBorders rotateMatrixBorders;
    @BeforeEach
    void init() {
        rotateMatrixBorders = new RotateMatrixBorders();
    }

    // 6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
    @Test
    void rotateMatrixBorders_Test() {
        //given
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] answer = rotateMatrixBorders.solution(rows, columns, queries);
        int[] expectedAnswer = {8, 10, 25};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

    // 3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
    @Test
    void rotateMatrixBorders_Test1() {
        //given
        int rows = 3;
        int columns = 3;
        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int[] answer = rotateMatrixBorders.solution(rows, columns, queries);
        int[] expectedAnswer = {1, 1, 5, 3};

        assertThat(answer).isEqualTo(expectedAnswer);
    }


    // 100	97	[[1,1,100,97]]	[1]
    @Test
    void rotateMatrixBorders_Test2() {
        //given
        int rows = 100;
        int columns = 97;
        int[][] queries = {{1,1,100,97}};

        int[] answer = rotateMatrixBorders.solution(rows, columns, queries);
        int[] expectedAnswer = {1};

        assertThat(answer).isEqualTo(expectedAnswer);
    }
}