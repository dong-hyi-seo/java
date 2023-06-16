package programmers.dfs_bfs;

/**
 * 네트워크
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network {

    /**
     * int n = 3;
     * int[][] computers = {
     *  {1, 1, 0}, A
     *  {1, 1, 0}, B
     *  {0, 0, 1} C
     * };
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        //첫번째 노드에대해서 연결된 것을 찾는다. 연결된것끼리 방문여부를 visited index에 맞게 true로 변환
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                //방문하지 않았떤것은 dfs로 찾게한다. 방문하지 않았던 노드의 탐색을한다는것은 끊어져있따는것이기떄문에 그노드부터 다시 연결된 것을 찾는다.
                DFS(i, computers, visited);
                answer ++; //끊어진 시점이기떄문에 count ++ 해준다.
            }
        }
        return answer;
    }

    static void DFS(int node, int[][] computers, boolean[] visited) {
        visited[node] = true; //방문했다고 표시!
        //들어온 node에 대해서 재귀로 찾는다
        for (int i=0; i<computers.length; i++) {
            //자기자신이 아니면서, 자기자신과 연결이 되어있고, 방문한적 없는 것들!
            if (node != i && computers[node][i] == 1 && !visited[i]) {
                DFS(i, computers, visited); //첫번째 node로 받은것에 대해서 위 조건에 부합하는 자식 node를 찾아 재귀를 돌려준다.
            }
        }
    }
}
