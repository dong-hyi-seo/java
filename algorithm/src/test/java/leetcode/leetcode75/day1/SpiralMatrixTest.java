package leetcode.leetcode75.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SpiralMatrixTest {

    private SpiralMatrix spiralMatrix;

    @BeforeEach
    void init() {
        spiralMatrix = new SpiralMatrix();
    }

    @Test
    void setSpiralMatrix_Test() {
        //givne
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //when
        List<Integer> answer = spiralMatrix.spiralOrder(matrix);
        //then
        List<Integer> expected = List.of(1,2,3,4,8,12,11,10,9,5,6,7);
        assertThat(answer).isEqualTo(expected);
    }

}