package programmers.complete_search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 전력망을 둘로 나누기 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class DivideThePowerGridInTwo {
    static int[][] graph;

    /**
     * 주어진 이차원배열 wires에서 하나만 참조하고있는 숫자에 해당하는 i를 제외한 나머지에 대해서 잘랐을경우
     * 남은 값 기준으로 잘라 송전탑개수의 차이를 계산한다.
     *  int n = 9;
     *  int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
     */
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        //1. 인접행렬에 input
        /**
         * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
         * [0, 1, 1, 0, 1, 0, 0, 0, 0, 0]
         * [0, 0, 0, 1, 0, 1, 1, 1, 0, 0]
         * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 1, 0, 0, 0, 1, 1]
         * [0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
         * 노드가 어느 노드와 연결되어있는지? 연결되어 있으면 1, 안되어있으면 0
         */
        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]][wires[i][1]]=1;
            graph[wires[i][1]][wires[i][0]]=1;
        }

        //선하나씩 끊으면서 찾자
        for (int i=0; i<wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            //선 끊기 0으로 할당
            graph[from][to] = 0;
            graph[to][from] = 0;

            int count = bfs(from, n);
            answer = Math.min(answer, count);


            //다시 이어준다.. 또다른 bfs로 찾기위해
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    /**
     * int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
     * 1. bfs(1, 9)
     * visited = [false, true, false, true, false, false, false, false, false, false]
     * node 1에대해서 3번 노드만 연결되어있으니 count 값은 1이며 그차이가 절대값 7이다
     *
     * 2. bfs(2, 9) 1번 노드를 끊었을때와 같다
     * 3. bfs(3, 9)
     * visited = [false, true, true, true, true, false, false, false, false, false]
     *
     */
    public static int bfs(int from, int n) {
        boolean[] visited = new boolean[n+1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        visited[from] = true;
        queue.offer(from);

        while(!queue.isEmpty()){
            int temp = queue.poll();

            //int i = 1부터인 이유는 graph 첫번째 요소는 무의미함
            for (int i=1; i<=n; i++) {
                //체크하고자하는 노드의 인접행렬정보에서 어느 노드와 연결되었는지 여부와 방문을 안했떤 노드인지?)
                if(graph[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                    count ++;
                }
            }
        }
        return (int)Math.abs(count-(n-count));
    }
}
