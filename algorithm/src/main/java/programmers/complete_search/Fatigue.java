package programmers.complete_search;

import java.util.Arrays;

public class Fatigue {

    private int answer = 0;
    /**
     * int k : 유저의 현재 피로도
     * int[][] dungeons : 최소필요피로도, 소모피로도
     *  //80	[[80,20],[50,40],[30,10]]	3
     *  [1던전, 2던전, 3던전] 에 관한 순열을 만든다.
     *  1. [1, 2, 3, 12, 23, 31, 21, 13, 32, 123, 132, 213, 231, 321, 312]
     *  이렇게 갈수있는 던전조합의수에서 현재 피로도보다 같거나 작은값을 뽑는다.
     *  이중 많이조합된 카운트를 리턴
     */
    public int solution(int k, int[][] dungeons) {

        int[] output = new int[dungeons.length];
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, 0, k);

        return answer;

    }

    /**
     *  유저의 현재 피로도가 K -> K가 최소피로도보다 작을때
     */
    private void dfs(int[][] dungeons, boolean[] visited, int depth, int K) {

        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= K) {
                visited[i] = true;
                dfs(dungeons, visited, depth+1, K - dungeons[i][1]);
                visited[i] = false;
            }
        }
        //결국 Depth값이 최대 많이 탐색한수이니까 최댓값찾으면됨
        answer = Math.max(answer, depth);
    }
}
