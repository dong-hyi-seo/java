package programmers.stack_queue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class StockPriceTest {

    private StockPrice stockPrice;

    @BeforeEach
    void init() {
        stockPrice = new StockPrice();
    }

    @Test
    void stockPrice_Test1() {

        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = stockPrice.solution(prices);
        int[] expectedAnswer = {4, 3, 1, 1, 0};

        assertThat(answer).isEqualTo(expectedAnswer);
    }

}