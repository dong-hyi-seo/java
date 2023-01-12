package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author donghyi.seo
 * @since 2022-12-7
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 이중우선순위큐
 *
 * 문제 설명
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 *
 * 명령어	수신 탑(높이)
 * I 숫자	큐에 주어진 숫자를 삽입합니다.
 * D 1	큐에서 최댓값을 삭제합니다.
 * D -1	큐에서 최솟값을 삭제합니다.
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 *
 * 제한사항
 * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
 * operations의 원소는 큐가 수행할 연산을 나타냅니다.
 * 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
 * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
 * 입출력 예
 * operations	return
 * ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
 * ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
 */
public class DoublePriorityQueueSolution {

    /**
     * 1. 나의 첫번째 생각
     * - 자바의 우선순위큐 자료구조를 사용 ?!
     * @param operations ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"] (명려어)
     * @return [0,0]
     */
    public int[] mySolution(String[] operations) {

        //오름차순 정렬 (최소힙)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        //내림차순 정렬 (최대힙)
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1); // 내림차순 정렬
            }
        });

        int[] answer = {0, 0};
        for (String commandStr : operations) {
            String [] commandArr = commandStr.split(" ");
            String commandType = commandArr[0];
            int commandNumber = Integer.parseInt(commandArr[1]);


            //빈 큐에 데이터를 삭제 요청 경우 연산 무시
            if (minPq.size() < 1 && commandType.equals("D")) {
                continue;
            }

            if (commandType.equals("I")) { //삽입
                minPq.add(commandNumber);
                maxPq.add(commandNumber);
                continue;
            }
            if (commandType.equals("D")){
                if (commandNumber == 1) { //최댓값을 삭제
                    int max = maxPq.poll();
                    minPq.remove(max);
                } else if (commandNumber == -1) { //최솟값 삭제
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }
        if (minPq.size() > 0) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }
}
