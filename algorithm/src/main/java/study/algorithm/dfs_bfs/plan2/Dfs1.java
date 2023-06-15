package study.algorithm.dfs_bfs.plan2;

import java.util.Arrays;
import java.util.Stack;

/**
 * DFS
 * https://www.youtube.com/watch?v=x8Zwup81DlA
 */
public class Dfs1 {
    int count;
    boolean[] visited;
    Stack<Integer> stack;
    int[][] matrix;

    public static void main(String[] args) {
        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        Dfs1 dfs1 = new Dfs1(count);

        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        System.out.println("graph matrix = " + Arrays.deepToString(graph.getMatrix()));
        dfs1.matrix = graph.getMatrix();
        dfs1.dfsTraversal();
    }

    public Dfs1(int count) {
        this.count = count;
        visited = new boolean[count];
        stack = new Stack<>();
    }

    public void dfsTraversal() {
        stack.push(0);
        visited[0] = true;

        while (stack.size() != 0) {
            int node = stack.pop();
            System.out.println(node + " ");
            for (int j=0; j<count; j++) {
                if(matrix[node][j] != 0  && !visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }


}
