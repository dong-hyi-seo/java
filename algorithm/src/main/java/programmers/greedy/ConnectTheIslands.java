package programmers.greedy;

import java.util.Arrays;

/**
 * 크루스칼 알고리즘 (최소신장트리)
 * 섬 연결하기 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42861
 *
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
 * 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한
 * 최소 비용을 return 하도록 solution을 완성하세요.
 *
 * 섬의 개수 n은 1 이상 100 이하입니다.
 * costs의 길이는 ((n-1) * n) / 2이하입니다.
 * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고,
 * costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
 * 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다.
 * 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
 * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
 * 연결할 수 없는 섬은 주어지지 않습니다.
 *
 * 다리를 여러 번 건너더라도,
 * 도달할 수만 있으면 통행 가능하다고 봅니다.
 * 예를 들어 A 섬과 B 섬 사이에 다리가 있고,
 * B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
 *
 * 딱봐도 크루스칼 알고리즘으로 최소비용을 구하는 것이다 !!
 */
public class ConnectTheIslands {

    /**
     * int n = 4;
     *
     * //첫번째와 두번째는 서로 여결되어있고 마지막 값은 두섬을 연결할때 드는 비용
     * int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
     */
    public int solution(int n, int[][] costs) {
        int answer = 0;


        //부모 상태를 담는 배열 초기화
        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }
        //cost 순서대로 정렬
        //간선기준으로 graph를 정렬한다 (오름차순)
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for(int[] node : costs) {
            int a = node[0];
            int b = node[1];
            int cost = node[2];
            if(find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
            }
        }
        return answer;
    }

    public static int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent, parent[node]);
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
