package programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoyStickTest {

    private JoyStick joyStick;

    @BeforeEach
    void init() {
        joyStick = new JoyStick();
    }

    @Test
    void mySolution_Test() {

        //String name1 = "JEROEN";
        String name2 = "BBBBAAAAAAAB";

        //int answer1 = joyStick.solution(name1);
        int answer2 = joyStick.solution(name2);

        //Assertions.assertThat(answer1).isEqualTo(56);
        Assertions.assertThat(answer2).isEqualTo(10);
    }

}