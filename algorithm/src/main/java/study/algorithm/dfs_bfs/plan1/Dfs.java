package study.algorithm.dfs_bfs.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author donghyi.seo
 * @since 2023-01-06
 */
public class Dfs {

    public static boolean[] visited = new boolean[9];
    public static List<List<Integer>> graph = Arrays.asList(

            new ArrayList<>(),
            Arrays.asList(2,3,8),
            Arrays.asList(1,7),
            Arrays.asList(1,4,5),
            Arrays.asList(3, 5),
            Arrays.asList(3, 4),
            List.of(7),
            Arrays.asList(2,6,8),
            Arrays.asList(1,7)
    );

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int v) {
        //현재 노드를 방문처리
        visited[v] = true;
        System.out.println("end = " + v);

        //현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i=0; i<graph.get(v).size(); i++) {
            int y = graph.get(v).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }
}
