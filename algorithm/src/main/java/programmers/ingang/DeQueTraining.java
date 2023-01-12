package programmers.ingang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * stack과 queue 구조 둘다 사용!
 * 앞에서 꺼내기도하고 뒤에서 꺼내기도 할때 DeQue 사용
 * LinkedList가 구현하고 있음
 *
 * offerFirst, offerLast (추가)
 * pollFirst, pollLast (제거)
 * peekFirst, peekLast (확인)
 */
public class DeQueTraining {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);

        deque.offerFirst(0);
        deque.offerLast(5);

        System.out.println(deque);
    }
}
