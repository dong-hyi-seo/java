package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FatigueTest {

    private Fatigue fatigue;

    @BeforeEach
    void init() {
        fatigue = new Fatigue();
    }

    @Test
    void fatigue_Test1() {
        //80	[[80,20],[50,40],[30,10]]	3
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        int answer = fatigue.solution(k, dungeons);

        assertThat(answer).isEqualTo(3);
    }
}