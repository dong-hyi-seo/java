package programmers.stack_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CorrectParenthessTest {

    private CorrectParenthess correctParenthess;

    @BeforeEach
    void init() {
        correctParenthess = new CorrectParenthess();
    }

    @Test
    void correctParenthess_Test1() {
        final String s = "()()";

        boolean answer = correctParenthess.solution(s);

        assertThat(answer).isTrue();
    }

    @Test
    void correctParenthess_Test2() {
        final String s = "(())()";

        boolean answer = correctParenthess.solution(s);

        assertThat(answer).isTrue();

    }

    @Test
    void correctParenthess_Test3() {
        final String s = ")()(";

        boolean answer = correctParenthess.solution(s);

        assertThat(answer).isFalse();
    }

    @Test
    void correctParenthess_Test4() {
        final String s = "(()(";

        boolean answer = correctParenthess.solution(s);

        assertThat(answer).isFalse();
    }

    @Test
    void correctParenthess_Test5() {
        final String s = "())(()";

        boolean answer = correctParenthess.solution(s);

        assertThat(answer).isFalse();
    }
}