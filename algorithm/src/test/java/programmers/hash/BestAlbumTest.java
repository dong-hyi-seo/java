package programmers.hash;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BestAlbumTest {

    private BestAlbum bestAlbum;

    @BeforeEach
    void init() {
        bestAlbum = new BestAlbum();
    }

    @Test
    void bestAlbum_Test1() {
        //given
        final String[] generes = {"classic", "pop", "classic", "classic", "pop"};
        final int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = bestAlbum.solution(generes, plays);
        int[] expectedAnswer = {4, 1, 3, 0};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}