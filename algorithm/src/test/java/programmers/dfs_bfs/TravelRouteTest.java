package programmers.dfs_bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TravelRouteTest {

    private TravelRoute travelRoute;

    @BeforeEach
    void init() {
        travelRoute = new TravelRoute();
    }

    @Test
    void travelRoute_Test() {
        //given
        final String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        //when
        final String[] answer = travelRoute.solution(tickets);

        //then
        final String[] expectedAnswer = {"ICN", "JFK", "HND", "IAD"};
        assertThat(answer).isEqualTo(expectedAnswer);
    }

    @Test
    void travelRoute_Test2() {
        //given
        final String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        //when
        final String[] answer = travelRoute.solution(tickets);

        //then
        final String[] expectedAnswer = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        assertThat(answer).isEqualTo(expectedAnswer);
    }

}