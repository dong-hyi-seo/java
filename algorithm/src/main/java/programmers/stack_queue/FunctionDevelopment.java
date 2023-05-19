package programmers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 기능개발 - Level2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 입출력 예
 * progresses	speeds	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * 입출력 예 설명
 * 입출력 예 #1
 * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
 * 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 *
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 */
public class FunctionDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int remainDay = (int) Math.ceil((float) remainProgress / speeds[i]);
            queue.add(remainDay);
        }

        int cnt = 0;
        int day = queue.peek();
        while (!queue.isEmpty()) {
            int checkDay = queue.poll();
            if (day >= checkDay) {
                cnt ++;
            } else {
                list.add(cnt);
                cnt = 1;
                day = checkDay;
            }

            if (queue.isEmpty()) {
                list.add(cnt);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
