package programmers.ingang;

import programmers.ingang.SetTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SetTrainingTest {

    private SetTraining setTraining;

    @BeforeEach
    void init() {
        setTraining = new SetTraining();
    }

    @DisplayName("[Set] 로또 번호 검출기")
    @Test
    void lottoMySolution() {
        //given
        int[] lotto1 = {4, 7, 32, 43, 22, 19};
        int[] lotto2 = {3, 19, 34, 39, 39, 20};

        //when
        boolean answer1 = setTraining.lottoMySolution(lotto1);
        boolean answer2 = setTraining.lottoMySolution(lotto2);

        //then
        assertThat(answer1).isTrue();
        assertThat(answer2).isFalse();

    }

    @DisplayName("[Set] 끝말 잇기")
    @Test
    void endToEndMySolutionTest() {
        //given
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream"};
        String[] words2 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        //when
        boolean answer1 = setTraining.endToEndMySolution(words1);
        boolean answer2 = setTraining.endToEndMySolution(words2);

        //then
        assertThat(answer1).isTrue();
        assertThat(answer2).isFalse();
    }

    @DisplayName("[Set] 같은 숫자는 싫어")
    @Test
    void notLikeSameNumSolutionTest() {
        //given
        int [] arr1 = {1,1,3,3,0,1,1};
        int [] arr2 = {4,4,4,3,3};

        //when
        int[] answer1 = setTraining.notLikeSameNumSolution(arr1);
        int[] answer2 = setTraining.notLikeSameNumSolution(arr2);

        //then
        int[] expectAnswer1 = {1,3,0,1};
        int[] expectAnswer2 = {4,3};

        assertThat(answer1).isEqualTo(expectAnswer1);
        assertThat(answer2).isEqualTo(expectAnswer2);
    }

}