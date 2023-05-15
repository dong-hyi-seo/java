package programmers.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NotCompletedPlayerTest {

    private NotCompletedPlayer notCompletedPlayer;

    @BeforeEach
    void init() {
        notCompletedPlayer = new NotCompletedPlayer();
    }

    @Test
    void notCompletedPlayer_Test1() {
        //given
        final String[] participant = {"leo", "kiki", "eden"};
        final String[] completion = {"eden", "kiki"};

        //when
        String answer = notCompletedPlayer.solution(participant, completion);

        //then
        assertThat(answer).isEqualTo("leo");

    }

    @Test
    void notCompletedPlayer_Test2() {
        //given
        final String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        final String[] completion = {"josipa", "filipa", "marina", "nikola"};

        //when
        String answer = notCompletedPlayer.solution(participant, completion);

        //then
        assertThat(answer).isEqualTo("vinko");

    }

    @Test
    void notCompletedPlayer_Test3() {
        //given
        final String[] participant = {"mislav", "stanko", "mislav", "ana"};
        final String[] completion = {"stanko", "ana", "mislav"};

        //when
        String answer = notCompletedPlayer.solution(participant, completion);

        //then
        assertThat(answer).isEqualTo("mislav");

    }

}