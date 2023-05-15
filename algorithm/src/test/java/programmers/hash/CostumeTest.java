package programmers.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class CostumeTest {

    private Costume costume;

    @BeforeEach
    void init() {
        costume = new Costume();
    }

    @Test
    void costume_Test1() {
        //given
        final String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        //when
        int answer = costume.solution(clothes);

        //then
        assertThat(answer).isEqualTo(5);
    }

    @Test
    void costume_Test2() {
        //given
        final String[][] clothes = {{"greenturban", "headgear"}, {"yellowturban", "headgear"}};

        //when
        int answer = costume.solution(clothes);

        //then
        assertThat(answer).isEqualTo(2);
    }

}