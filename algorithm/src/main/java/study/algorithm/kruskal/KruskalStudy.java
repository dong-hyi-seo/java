package study.algorithm.kruskal;

import java.util.Arrays;

/**
 * Kruskal (최소신장트리)
 * REFER
 * 1. youtube URL : https://www.youtube.com/watch?v=BJZwRWNGFMU (이론)
 * 2. youtube URL : https://www.youtube.com/watch?v=LQ3JHknGy8c (코딩)
 * 3. blog url : https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BCKruskal-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 각 노드와 연결되어있는 선이있는데 선에 가중치가존재하여 그 가중치 최솟값찾기 ?
 * 가중치가 작은것대로 순서대로 찾는것
 * 가중치를 작은것대로 찾아나가며서 노드들이 순환싸이클이 발생하면 해당 간선은 선택하지 않는다.
 *
 * 모든 노드가 방문됬을때 멈춘다.
 * union : 사이클이 이루어지 않는다면 연결하는 역할
 * find : 서클을 이루는지 확인 ?
 *
 * 1. (v, w, cost) = (1, 3, 3)
 * find(1) = 1, find(3) = 3
 * v, w 부모노드가 다르므로 간선을 MST에 추가했을때 사이클이 생기지 않는다. 따라서 이 간선을 MST에 추가한다.
 * 노드1과 노드3을 union(1, 3)을 수행하여 같은 MST에 속해있또록 한다.
 *
 */
public class KruskalStudy {

    /**
     * 첫번째, 두번째 element들은 연결된 노드의 명
     * 마지막 element는 연결된 두 노드의 간선 비용
     */
    private final static int[][] graph = {{1,3,3}, {1,4,8}, {4,5,9}, {1,2,10}, {2,3,13}, {2,5,14}};

    public static void main(String[] args) {
        kruskal();
    }

    public static void kruskal() {

        int n = 5; //전체 노드수;

        //간선기준으로 graph를 정렬한다 (오름차순)
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
        System.out.println("간선 기준 오름차순 정렬 graph : " + Arrays.deepToString(graph));

        //부모노드 초기화 (순환싸이클을 파악하기위한 값)
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        System.out.println("parent 초기 값 : " + Arrays.toString(parent));
        int totalCoast = 0;
        for (int[] nodeInfo : graph) {
            int a = nodeInfo[0];
            int b = nodeInfo[1];
            int cost = nodeInfo[2];

            //서로 다른 부모를 바라보고있으면 ?
            //node 4, 5
            //find(4) = 1, find(5) = 5
            if (find(parent, a) != find(parent, b)) {
                totalCoast += cost;
                union(parent, a, b);
            }
        }
        System.out.println("totalCoast = " + totalCoast);
    }

    /**
     * node = 4, 5
     * patent = [1, 2, 1, 1, 5]
     *
     * patent[4] -> 1 == 4 다르니까
     * 부모를 찾는다. find(patent, 1) return 1 이됨
     *
     * patent[5] -> 5 == 5
     */
    public static int find(int[] patent, int node) {
        if (patent[node] == node) {
            return node;
        }
        return find(patent, patent[node]);
    }

    /**
     * a = 4, b = 5
     * patent = [1, 2, 1, 1, 5]
     * 입력받은 node의 부모를 찾아주어 patent에 할당해준다.
     */
    public static void union(int[] parent, int a, int b) {
        System.out.println(" ============= ");
        System.out.println("before patent = " + Arrays.toString(parent));
        System.out.println("before union a : " + a + " // b : " + b);
        a = find(parent, a); //1
        b = find(parent, b); //5


        if(a < b) parent[a] = b;
        else parent[a] = b;
        System.out.println("after union a : " + a + " // b : " + b);
        System.out.println("after patent = " + Arrays.toString(parent));
    }
}
