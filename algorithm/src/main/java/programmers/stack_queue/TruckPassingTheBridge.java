package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42583
 *
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모
 * 든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 *
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 */
public class TruckPassingTheBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int sum = 0; //다리를 건너는 트럭들의 무게합

        //큐가 비어있으면? (다리를 건너는 트럭이 없다)
            //다음 트럭을 추가하고 그무게를 sum에 더해주고 시간을 증가 !
        //큐가 비어있지않을때 다리위에 트럭이 있을때다
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<truck_weights.length; i++) {

            int truck = truck_weights[i];
            System.out.println("truck = " + truck);
            while (true) {
                //queue(다리)가 비어있으면 다음 트럭 삽입
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sum += truck;
                    answer ++;
                    System.out.println("다리에 있는 애들 : " + queue + " // 다리의 무게 : " + sum + " // 지난시간 : " + answer);
                    break; //차가 한대 들어갔으니 빠져나가고 다음차에대한 계산
                } else { //다리가 비어있지 않으면 ?

                    //현재 다리에 있는 사이즈와 다리사이즈가 같다면 큐에서 처음 값을 빼고 무게 합 -
                    if (queue.size() == bridge_length) {
                        sum -= queue.poll();
                        System.out.println("다리에 꽉차서 나감 : " + queue + " // 다리의 무게 : " + sum + " // 지난시간 : " + answer);
                    } else if (sum + truck > weight) { //다음트럭이 다리를 건너려고할때 제한된 무게를 초과하면 ?
                        queue.offer(0);
                        answer++; //여기서 시간을 증가해주는이유는 현재 다리에 차가 꽉차서 시간이 지나기때문에 ! 1초 증가
                        System.out.println("다음차가 초과 : " + queue + " // 다리의 무게 : " + sum + " // 지난시간 : " + answer);
                    } else {
                        queue.offer(truck);
                        sum += truck;
                        answer ++;
                        System.out.println("다음차 들어가 : " + queue + " // 다리의 무게 : " + sum + " // 지난시간 : " + answer);
                        break; //break를 주는 시점은 차한대가 빠져나갈때 주는거다!
                    }
                }
            }
        }
        return answer + bridge_length; //마지막차 다리의 길이만큼 추가해줘야함
    }

}
