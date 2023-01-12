package programmers.ingang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue (퍼리오리큐)
 * 우선순위 큐로써 일반적인 큐의 구조 FIFO를 가지면서 데이터가 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고
 * 그 우선순위가 높은 데이터가 먼저 나가는 자료구죠
 * 내부 요소는 힙으로 구성되어 이진트리 구조
 * 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
 * 우선순위를 중요시해야 하는 상황에서 주로 쓰인다.
 * 우선순위 큐에 저장할 객체는 필수적으로 Comparable Interface를 구현해야한다.
 *
 * // 첫번째 값을 반환하고 제거 비어있다면 null
 * priorityQueueLowest.poll();
 *
 * // 첫번째 값 제거 비어있다면 예외 발생
 * priorityQueueLowest.remove();
 *
 * // 첫번째 값을 반환만 하고 제거 하지는 않는다.
 * // 큐가 비어있다면 null을 반환
 * priorityQueueLowest.peek();
 *
 * // 첫번째 값을 반환만 하고 제거 하지는 않는다.
 * // 큐가 비어있다면 예외 발생
 * priorityQueueLowest.element();
 *
 * // 초기화
 * priorityQueueLowest.clear();
 *
 */
public class PriorityQueueTraining {

    public static void main(String[] args) {
        //integer로 높은숫자부터 우선순위 선정하여 나오게끔 !
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueHighest.add(1);
        priorityQueueHighest.add(6);
        priorityQueueHighest.add(3);
        priorityQueueHighest.add(100);

        while (!priorityQueueHighest.isEmpty()) {
            System.out.println("우선순위큐 높은숫자부터 나오나? : " + priorityQueueHighest.poll());
        }
    }

    /**
     * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
     * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
     * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
     *
     * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
     * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
     * 3. 그렇지 않으면 J를 인쇄합니다.
     * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
     *
     * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
     *
     * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열
     * priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
     * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
     * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
     * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
     * 입출력 예
     * priorities	location	return
     * [2, 1, 3, 2]	2	1
     * [1, 1, 9, 1, 1, 1]	0	5
     */
    public int printerMySolution(int[] priorities, int location) {
        int answer = 0;

        //우선순위 큐 사용 (내림차순으로 정렬)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer target : priorities) {
            priorityQueue.add(target);
        }

        //2, 3, 5, 1 -> 5, 1, 2, 3 (location 2) -> 정답은 4번쨰
        //9,1,1,1,1,1 vs 1,1,9,1,1,1 (location : 0)
        while (!priorityQueue.isEmpty()) { //5, 3, 2, 1
            //원래 입력받은 프린터 대기목록 배열
            for (int i=0; i<priorities.length; i++) { // 2, 3, 5, 1
                if (priorities[i] == priorityQueue.element()) {
                    if (i == location) { //3
                        answer++;
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++; //인쇄 순번을 뜻하기때문에
                    //5가 첫번쨰 인쇄 항목 (i : 2)
                    //3이 두번쨰 인쇄 항목 (i : 1)
                    //2가 세번째 인쇄 항목 (i : 0)
                    //1이 네번쨰 인쇄 항목 (i : 4) == location 일치!
                }
            }
        }
        return -1;
    }

    class Task{
        int location;
        int priority;
        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int printerAnotherSolution(int[] priorities, int location) {
        int answer = 0;

        Queue<Task> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            //몇번째 index에 있고 우선순위가 몇인 프린터 대기 항목인지 class로 queue에 넣어둔다
            queue.add(new Task(i, priorities[i]));
        }
        //1, 1, 9, 1, 1, 1 (location : 0)
        // -- debug --
        //1:0, 1:1, 9:2, 1:3, 1:4, 1:5 (now : 0) (flat : true)
        //1:1, 9:2, 1:3, 1:4, 1:5, 1:0 (now : 0) (flag : true)
        //9:2, 1:3, 1:4, 1:5, 1:0, 1:1 (now : 1) (flag : false)
        //1:3, 1:4, 1:5, 1:0, 1:1
        int now = 0;
        while(!queue.isEmpty()){
            Task cur = queue.poll(); //맨앞의 큐 객체를 뽑고 제거
            boolean flag = false;
            for (Task t: queue) {
                //대상 우선순위보다 높은것이 있을경우
                if (cur.priority < t.priority) {
                    flag = true;
                }
            }
            //우선순위 높은게 있으면 뒤로 보낸다!
            //문제 설명상에 중요도 더 높은 대기항목이 있을경우 맨뒤로 가게됨
            if (flag) {
                queue.add(cur);
            } else {
                now++; //인쇄 대기 순서를 뜻한다 now값은! 데이터 지워질때마다 +1을해줘 순번을 기억하자
                if(cur.location == location) { //내가 찾던 location일때의 순번은 ?!!
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }

}
