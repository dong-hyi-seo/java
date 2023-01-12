package programmers.ingang;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author donghyi.seo
 * @since 2022-08-24
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
 *
 * 길이가 같은 두 개의 큐가 주어집니다. 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert)
 * 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다.
 * 이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.
 *
 * 큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며,
 * 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다.
 * 즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다.
 * 예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며,
 * 이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.
 *
 * 다음은 두 큐를 나타내는 예시입니다.
 *
 * queue1 = [3, 2, 7, 2]
 * queue2 = [4, 6, 5, 1]
 * 두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다.
 * 예를 들어, 다음과 같이 2가지 방법이 있습니다.
 *
 * queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여
 * queue2에 추가합니다. 그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.
 * queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다.
 * 그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다.
 * 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
 * 따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.
 *
 * 길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다.
 * 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요.
 * 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
 *
 * 입출력 예
 * queue1	queue2	result
 * [3, 2, 7, 2]	[4, 6, 5, 1]	2
 * [1, 2, 1, 2]	[1, 10, 1, 2]	7
 * [1, 1]	[1, 5]	-1
 */
public class SumOfTwoQueues {

    public int mySolution(int[] queue1, int[] queue2) {

        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        // initialize
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        System.out.println("queue1 = " + Arrays.toString(queue1));
        System.out.println("queue2 = " + Arrays.toString(queue2));

        //answer 는 queue1과 queue2의 원소합이 같게만들어지는 최소 횟수
        int cnt = 0;

        //구해야될 합을 구한다
        long queue1Sum = Arrays.stream(queue1).sum();
        long queue2Sum = Arrays.stream(queue2).sum();
        long sum = queue1Sum + queue2Sum;

        //두 배열 원소들의 합을 나누기 2 했을때 나머지가 1이면 결국 각 큐의 원소 합을 같게 만들수 없다.
        if(sum % 2 == 1) return -1;

        long resultSum = sum / 2;
        System.out.println("resultSum = " + resultSum);

        //queue1 : [3, 2, 7, 1]
        //queue2 : [4, 6, 5, 1]
        //해당 횟수는 2에서 3 또는 3에서 4로 변경하면서 다돌떄가지 제한
        while (cnt < queue1.length * 3) {
            if (queue1Sum > queue2Sum) {
                Integer poll = q1.poll();
                q2.add(poll);
                queue1Sum -= poll; //queue1에서 끄낸거니까 해당 sum 값에서 끄낸값을 제거
                queue2Sum += poll; //queue1에서 꺼내서 queue2에 담았으니 queue2에 해당하는 sum 값에 꺼낸값을 더한다
                cnt++; //횟수증가
            } else if (queue1Sum < queue2Sum) {
                Integer poll = q2.poll();
                q1.add(poll);
                queue1Sum += poll;
                queue2Sum -= poll;
                cnt++; //횟수증가
            } else { //queue1Sum == queue2Sum
                return cnt;
            }
        }//while finish
        return -1;
    }
}
