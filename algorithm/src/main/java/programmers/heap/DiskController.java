package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {
    /**
     * [작업이 요청되는 시점, 작업의 소요시간]
     * [0, 3] -> 3초 걸림
     * [1, 9] -> 2초동안 기다리다가 9초까지 실행하니 11초 (전 작업의 종료시간 - 현 작업의 들어오는시간 + 현작업의 실행시간) = 걸린시간 11초 , 끝나는시간12초
     * [2, 6] -> 2초시점에 들어오다가 6초까지 실행하니 16초 걸림 (전 작업의 종료시간 - 현 작업이 들어오는시간 + 현작업의 실행시간) = 걸리는시간 16초, 끝나는시간 18초
     *
     */
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        System.out.println("jobs = " + Arrays.deepToString(jobs));


        //작업 소요시간 기준으로 정렬 queue
        int length = jobs.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int answer = 0;
        int index = 0;
        int count = 0;
        int end = 0; //수행되고난 후의 종료시간
        //요청이 모두 수행될때까지 반복
        while (count < length) {

            //하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            //====1
            //index = 0, length = 3 jobs[0][0] = 0, end = 0

            //====2 (위 0번째께 끝나는 시점까지 들어온 나머지 요청들어온 항목들에 대하여 수행시간 비교하여 더 짧은것을 우선순위로 해야함
            //index = 1, length = 3 jobs[1][0] = 1, end = 3 -> [1,9]
            //index = 2, length = 3 jobs[2][0] = 2, end = 3 -> [2,6]
            while (index < length && jobs[index][0] <= end) {
                queue.add(jobs[index]);
                index++;
            }

            //큐가 비어있따는것은 end가 꼭 0부터시작하는것이나닌 제일 작은 요청시간대가 2일수도 있기때문에 end를 그시점에 맞춰준다.
            // 또한 큐가 비어있다면 작업 완료(end)이후에 다시 요청이 들어온다는 것도 됨
            if (queue.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] temp = queue.poll();
                answer +=  end - temp[0] + temp[1];
                end += temp[1];
                count ++;
                //answer = 3, end = 3, count = 1;
            }
            System.out.println("end = " + end);
        }

        return (int) Math.floor(answer / jobs.length);
    }

}
