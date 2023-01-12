package programmers.ingang;

import programmers.ingang.ArrayTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class ArrayTrainingTest {

    private ArrayTraining arrayTraining;

    @BeforeEach
    void init() {
        arrayTraining = new ArrayTraining();
    }

    @DisplayName("[Array] K번쨰 수")
    @Test
    void kSolutionTest() {
        //given
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        //when
        int[] answer = arrayTraining.kSolution(array, commands);

        //then
        int[] expactAnswer = {5,6,3};
        assertThat(answer).isEqualTo(expactAnswer);

    }

}