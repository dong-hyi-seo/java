package programmers.stack_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class TruckPassingTheBridgeTest {
    private TruckPassingTheBridge truckPassingTheBridge;

    @BeforeEach
    void init() {
        truckPassingTheBridge = new TruckPassingTheBridge();
    }

    @Test
    void truckPassingTheBridge_Test1() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int answer = truckPassingTheBridge.solution(bridge_length, weight, truck_weights);

        assertThat(answer).isEqualTo(8);
    }

    @Test
    void truckPassingTheBridge_Test2() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        int answer = truckPassingTheBridge.solution(bridge_length, weight, truck_weights);

        assertThat(answer).isEqualTo(101);
    }

    @Test
    void truckPassingTheBridge_Test3() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int answer = truckPassingTheBridge.solution(bridge_length, weight, truck_weights);

        assertThat(answer).isEqualTo(110);
    }
}