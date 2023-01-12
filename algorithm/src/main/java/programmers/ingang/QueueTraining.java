package programmers.ingang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Queue
 * 먼저 들어간놈을 먼저 뽑는다 (FIFO)
 * java에서는 interface로만 제공
 *
 * 밑에 함수 전자는 exception 발생 후자 함수는 special value 리턴 (null)
 * add : offer() -> 값을 추가하다
 * remove : poll() -> 앞에서부터 꺼내다
 * element : peek() -> 값을 확인 (값을 꺼내지 않고 확인만한다)
 *
 */
public class QueueTraining {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        //queue에 집어넣자
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println("queue = " + queue);

        queue.poll();
    }

    /**
     * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     *
     * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
     * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
     *
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
     * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     *
     * 제한 사항
     * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     * 작업 진도는 100 미만의 자연수입니다.
     * 작업 속도는 100 이하의 자연수입니다.
     * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
     * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     *
     * 입출력 예
     * progresses	speeds	return
     * [93, 30, 55]	[1, 30, 5]	[2, 1]
     * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
    public int[] developmentSolution(int[] progresses, int[] speeds) {


        Queue<Integer> queue = new LinkedList<>();
        for (int p=0; p<progresses.length; p++) {
            //남은진행율 구하기
            int remainingProgress = 100 - progresses[p];

            //8,7,9,4 -> [2, 2]
            //3, 4, 3, 5 -> [1, 2, 1]
            //더 해야될 작업일 구하기
            int speed = speeds[p];
            int remainingWorkingDay = (int) Math.ceil((double) remainingProgress / speed);
            queue.add(remainingWorkingDay);
        }

        List<Integer> answerList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int workingDay = queue.poll();
            int cnt = 1;

            //전 기능 남은일수가 다음꺼 보다 크거나 같을경우 동시 패치 (기능 + 1)
            while (!queue.isEmpty() && workingDay >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            answerList.add(cnt);
        }
        System.out.println(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }



}
