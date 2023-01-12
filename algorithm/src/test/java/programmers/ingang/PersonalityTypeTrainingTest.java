package programmers.ingang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.ingang.PersonalityTypeTraining;

import static org.assertj.core.api.Assertions.*;

class PersonalityTypeTrainingTest {

    private PersonalityTypeTraining personalityTypeTraining;

    @BeforeEach
    void init() {
        personalityTypeTraining = new PersonalityTypeTraining();
    }

    @DisplayName("[프로그래머스] 성격 검사 알고리즘 문제")
    @Test
    void mySolutionTest() {

        //given
        String[] survey = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        //when
        String answer = personalityTypeTraining.mySolution(survey, choices);
        String anotherAnswer = personalityTypeTraining.anotherSolution(survey, choices);

        //then
        assertThat(answer).isEqualTo("TCMA");
        assertThat(anotherAnswer).isEqualTo("TCMA");


    }

}