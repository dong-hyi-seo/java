package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WordChangeTest {
    private WordChange wordChange;

    @BeforeEach
    void init() {
        wordChange = new WordChange();
    }

    @Test
    void wordChange_Test() {
        //given
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        //when
        int answer = wordChange.solution(begin, target, words);

        //then
        assertThat(answer).isEqualTo(4);
    }

    @Test
    void wordChange_Test1() {
        //given
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        //when
        int answer = wordChange.solution(begin, target, words);

        //then
        assertThat(answer).isEqualTo(0);
    }
}