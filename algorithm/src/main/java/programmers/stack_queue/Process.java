package programmers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로세스 - Level2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *
 * 운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다.
 * 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
 *
 * 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
 * 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
 * 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
 *   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
 *
 * 예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고,
 * 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
 *
 * 현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와,
 * 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때,
 * 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
 *
 * //[1, 1, 9, 1, 1, 1] -> [A, B, C, D, E, F]
 *         //[9, 1, 1, 1, 1, 1] -> [C, D, E, F, A, B]
 */
public class Process {


    public int solution(int[] priorities, int location) {
        int answer = 0;

        //create queue
        Queue<Document> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.offer(new Document(priorities[i], location == i));
        }
        System.out.println("queue = " + queue);

        int order = 0;
        while (!queue.isEmpty()) {
            Document poll = queue.poll();
            boolean state = false;
            for (Document p : queue) {
                //첫번째로 꺼낸값보다 큰값이 있는경우 ???
                if (poll.value < p.value) {
                    state = true;
                    break;
                }
            }
            //state는 꺼낸값보다 남은큐에 값이 더 큰값이 하나라도 있을경우 뒤로보낸다
            if (state) {
                queue.offer(poll);
                //여기까지는 queue에 순서대로 정렬을 하는 것이다!
                continue;
            }

            //이때부터는 순서대로 정렬된 queue안에서 찾고자하는 원래 위치 데이터 정렬순서 값을 뽑으려고하는것
            order ++;
            if (poll.location) {
                answer = order;
            }
        }
        return answer;
    }


    class Document {
        int value;
        boolean location;

        public Document(int value, boolean location) {
            this.value = value;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "value=" + value +
                    ", location=" + location +
                    '}';
        }
    }


}
