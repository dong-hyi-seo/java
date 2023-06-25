package programmers.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *
 */
public class GameMap {

    //갈수있는 4개의 방향 미리 배열에저장(상,하,좌,우)
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    /**
     * {1,0,1,1,1},
     * {1,0,1,0,1},
     * {1,0,1,1,1},
     * {1,1,1,0,1},
     * {0,0,0,0,1}
     */
    public int solution(int[][] maps) {
        int answer = 0;

        //방문한 좌표를 저장할 이차원 배열 생성
        int[][] visited = new int[maps.length][maps[0].length];
        System.out.println("visited = " + Arrays.deepToString(visited));
        bfs(maps, visited);
        System.out.println("visited = " + Arrays.deepToString(visited));
        answer = visited[maps.length - 1][maps[0].length - 1]; // 상대 팀 진영 좌표

        if (answer == 0) { // 상대 팀 진영에 도달하지 못한 경우
            answer = -1;
        }
        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        //bfs queue 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // Queue에 시작 정점 추가
        visited[0][0] = 1;

        while (!q.isEmpty()) {// 더 나아갈 정점이 없을 때까지 반복
            int[] current = q.poll(); // 정점 하나 꺼내기
            System.out.println("current = " + Arrays.toString(current));
            int X = current[0]; //0
            int Y = current[1]; //0

            //정점에서 상,하,좌,우 방향 체크 (단, 벗어난범위면 다른방향체크)
            for (int i=0; i<4; i++) {
                int nX = X + dx[i];//상 : 4+0 // 하 : 4+0 //좌 : 4+(-1)
                int nY = Y + dy[i]; // 상 : 0 + (-1) // 하 : 0 + 1 // 좌 : 0 + 0
                ////===== 상단 모서리 시작지점 =====
                //nX = 0, nY = -1; (상) -> X
                //nX = 0, nY = 1; (하) => O
                //nX = -1, nY = 0; (좌) => X
                //nX = 1, nY = 0; (우) => O

                //// ====== 도착지점 ======
                //nX = 4, nY = 3 (상) -> O
                //nX = 4, nY = 5 (하) -> X (갈곳없다) .. nY가 maps[0].length - 1 보다 크면
                //nX = 5, nY = 4 (우) -> X (갈곳없다).. nX가 maps.length -1 보다 크면!!

                /**
                 * 벗어난경우?
                 * nx, ny가 0보다작은경우 벗어남
                 * nY가 maps[0].length - 1 보다 크면
                 * nX가 maps.length -1 보다 크면!!
                 */
                if (nX < 0 || nY < 0 || nY > maps[0].length - 1 || nX > maps.length - 1) {
                    continue;
                }

                //아직 방문하지 않았고 (0 인경우), 벽이 아닌경우 갈수있다 (1 인경우).
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[X][Y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }

}
