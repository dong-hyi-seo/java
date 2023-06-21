package programmers.greedy;

/**
 * 크루스칼 알고리즘 (최소신장트리)
 * 섬 연결하기 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42861
 *
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
 * 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한
 * 최소 비용을 return 하도록 solution을 완성하세요.
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

        //총 노드수를 구한다.

        //부모 상태를 담는 배열 초기화
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
