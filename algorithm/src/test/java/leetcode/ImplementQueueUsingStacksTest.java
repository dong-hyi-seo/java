package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
class ImplementQueueUsingStacksTest {

    private ImplementQueueUsingStacks implementQueueUsingStacks;

    @BeforeEach
    void init() {
        implementQueueUsingStacks = new ImplementQueueUsingStacks();
    }

    /**
     *  ["MyQueue", "push", "push", "peek", "pop", "empty"] [[], [1]
     *  , [2], [], [], []] 출력
     *  [null , null, null, 1, 1, false] 설명
     *  MyQueue myQueue = new MyQueue();
     *  myQueue.push(1); // 대기열: [1]
     *  myQueue.push(2); // 대기열: [1, 2](가장 왼쪽이 대기열의 앞)
     *  myQueue.peek(); // 1 반환
     *  myQueue.pop(); // 1 반환, 큐는 [2]
     *  myQueue.empty(); // 거짓 반환
     */
    @Test
    void implementQueueUsingStacks_Test() {
        //given
        ImplementQueueUsingStacks.MyQueue myQueue = new ImplementQueueUsingStacks.MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        assertThat(myQueue.peek()).isEqualTo(1);
        assertThat(myQueue.pop()).isEqualTo(1);
        assertThat(myQueue.peek()).isEqualTo(2);
        assertThat(myQueue.empty()).isFalse();
    }

    @Test
    void implementQueueUsingStacks_Push_Empty_Test() {
        ImplementQueueUsingStacks.MyQueue myQueue = new ImplementQueueUsingStacks.MyQueue();
        myQueue.push(1);
        assertThat(myQueue.empty()).isFalse();
    }
}