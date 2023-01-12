package programmers.ingang;

import programmers.ingang.MapTraining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
class MapTrainingTest {

    private MapTraining mapTraining;

    @BeforeEach
    void init() {
        mapTraining = new MapTraining();
    }

    @Test
    @DisplayName("[MAP 공부] 포켓몬 알고리즘 테스트")
    void pocketMonSolutionTest() {
        //given
        int[] questionArr1 = new int[]{3,1,2,3};
        int[] questionArr2 = new int[]{3,3,3,2,2,4};
        int[] questionArr3 = new int[]{3,3,3,2,2,2};

        //when
        int answer1= mapTraining.pocketMonMySolution(questionArr1);
        int answer2 = mapTraining.pocketMonMySolution(questionArr2);
        int answer3 = mapTraining.pocketMonMySolution(questionArr3);

        //then
        assertThat(answer1).isEqualTo(2);
        assertThat(answer2).isEqualTo(3);
        assertThat(answer3).isEqualTo(2);
    }

    @Test
    @DisplayName("[Map 공부] 마라톤 알고리즘 테스트")
    void marathonMySolutionTest() {
        String[] participant1 = new String[]{"leo", "kiki", "eden"};
        String[] completion1 = new String[]{"eden", "kiki"};

        String[] participant2 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = new String[]{"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = new String[]{"stanko", "ana", "mislav"};

        //when
        String answer1= mapTraining.marathonMySolution(participant1, completion1);
        String anotherAnswer1= mapTraining.marathonAnotherSolution(participant1, completion1);

        String answer2= mapTraining.marathonMySolution(participant2, completion2);
        String anotherAnswer2= mapTraining.marathonAnotherSolution(participant2, completion2);

        String answer3= mapTraining.marathonMySolution(participant3, completion3);
        String anotherAnswer3= mapTraining.marathonAnotherSolution(participant3, completion3);

        //then
        assertThat(answer1).isEqualTo("leo");
        assertThat(anotherAnswer1).isEqualTo("leo");
        assertThat(answer2).isEqualTo("vinko");
        assertThat(anotherAnswer2).isEqualTo("vinko");
        assertThat(answer3).isEqualTo("mislav");
        assertThat(anotherAnswer3).isEqualTo("mislav");
    }

    @DisplayName("위장 테스트")
    @Test
    void camouflageMySolutionTest() {
        //given
        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println("clohtes1 = " + Arrays.deepToString(clothes1));

        //when
        int answer = mapTraining.camouflageMySolution(clothes1);

        //then
        assertThat(answer).isEqualTo(5);
    }

}