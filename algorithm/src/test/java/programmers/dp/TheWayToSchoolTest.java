package programmers.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TheWayToSchoolTest {

    private TheWayToSchool theWayToSchool;

    @BeforeEach
    void init() {
        theWayToSchool = new TheWayToSchool();
    }

    /**
     * m	n	puddles	return
     * 4	3	[[2, 2]]	4
     */
    @Test
    void theWayToSchool_Test() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int answer = theWayToSchool.solution(m, n, puddles);

        assertThat(answer).isEqualTo(4);
    }


}