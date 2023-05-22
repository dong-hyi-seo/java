package programmers.heap;

import java.util.PriorityQueue;

/**
 * 더 맵게 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class MoreSpicy {

    //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    //이 문제는 계쏙 K보다 작은값 위주로 반복을 돌려야하는데 자동정렬의 우선순위큐 자료구조가 제일 좋을듯
    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            queue.add(queue.poll() + queue.poll() * 2);
            answer ++;
        }
        return answer;
    }
}
