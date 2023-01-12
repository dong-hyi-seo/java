package programmers.hjh_study.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmers.level1.BabblingSolution;


import static org.assertj.core.api.Assertions.assertThat;

class BabblingSolutionTest {

    private BabblingSolution babblingSolution;

    @BeforeEach
    void init() {
        babblingSolution = new BabblingSolution();
    }

    /**
     * 발음할수있는것들 : "aya", "ye", "woo", "ma"
     * ["aya", "yee", "u", "maa"]	1
     * ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2
     */
    @Test
    void mySolution_Test() {
        //given
        String[] question1 = {"aya", "yee", "u", "maa"};
        String[] question2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        String[] question3 = {"wooyemawooye", "mayaa", "ymaeaya"};

        //when
        int answer1 = babblingSolution.mySolution(question1);
        int answer2 = babblingSolution.mySolution(question2);
        int answer3 = babblingSolution.mySolution(question3);

        assertThat(answer1).isEqualTo(1);
        assertThat(answer2).isEqualTo(2);
        assertThat(answer3).isEqualTo(1);
    }
}