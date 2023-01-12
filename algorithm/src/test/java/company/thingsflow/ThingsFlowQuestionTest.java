package company.thingsflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ThingsFlowQuestionTest {

    private ThingsFlowQuestion thingsFlowQuestion;

    @BeforeEach
    void init() {
        thingsFlowQuestion = new ThingsFlowQuestion();
    }

    @DisplayName("[ThingsFlow] 모스부호 변환 문제")
    @Test
    void thingsFlowQuestionTest() {
        //given
        String question = "DONG HYI SEO";

        //when
        String answer = thingsFlowQuestion.thingsFlowSolution(question);

        //then
        String expectedAnswer = "-.----...--- --..-.--.- -.--.-----";
        assertThat(answer).isEqualTo(expectedAnswer);
    }

}