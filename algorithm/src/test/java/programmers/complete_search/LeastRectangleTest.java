package programmers.complete_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LeastRectangleTest {

    private LeastRectangle leastRectangle;

    @BeforeEach
    void init() {
        leastRectangle = new LeastRectangle();
    }

    @Test
    void leastRectangle_Test1() {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int answer = leastRectangle.solution(sizes);

        assertThat(answer).isEqualTo(4000);
    }
}