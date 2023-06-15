package study.algorithm.dfs_bfs.plan2;

import java.util.ArrayList;
import java.util.Arrays;

public class Bfs1 {
    int count;
    boolean[] visited;
    ArrayList<Integer> queue;
    int[][] matrix;

    public static void main(String[] args) {
        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        Bfs1 bfs1 = new Bfs1(count);

        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        System.out.println("graph matrix = " + Arrays.deepToString(graph.getMatrix()));
        bfs1.matrix = graph.getMatrix();
        bfs1.bfsTraversal();
    }

    public Bfs1(int count) {
        this.count = count;
        visited = new boolean[count];
        queue = new ArrayList<>();
    }

    public void bfsTraversal() {
        queue.add(0);
        visited[0] = true;
        while(queue.size() != 0) {
            int node = queue.remove(0);
            System.out.print(node + " ");
            for (int i=0; i<count; i++) {
                if (matrix[node][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
