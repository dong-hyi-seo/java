package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VowelDictionaryTest {

    private VowelDictionary vowelDictionary;

    @BeforeEach
    void init() {
        vowelDictionary = new VowelDictionary();
    }

    @Test
    void vowelDictionary_Test() {
        //given
        String word = "AAAAE";

        int answer = vowelDictionary.solution(word);

        assertThat(answer).isEqualTo(6);
    }
}