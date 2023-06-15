package study.algorithm.dfs_bfs.plan1;

/**
 * 얼음문제
 *
 * N * M 크기의 얼음 특이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이 때 얼음틀의 모양이 주어졌을 떄 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
 * 다음의 4*5 얼음 틀 예시에서는 아이스크림이 총 3개 생성된다.
 *
 * - 입력 조건
 *     - 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로길이 M이 주어진다. (1≤N, M≤1000)
 *     - 두번째 줄부터 N+1 번째 줄까지 얼음 틀의 형태가 주어진다.
 *     - 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
 * - 출력조건
 *     - 한번에 만들 수 있는 아이스크림의 개수를 출력
 */
public class DfsQuestion {
    public static int answer = 0;
    public static int n = 4;
    public static int m = 5;
    public static final int[][] iceBoxGraph = {
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };
    public static boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        int result = 0;
        //상하좌우라고했으니 가로, 세로 이중반복문
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                //현재 위치에서 DFS 수행 한다.
                System.out.println("x = " + x + "/ y = " + y + " 좌표 확인");
                boolean b = DFS(x, y);
                System.out.println("b = " + b);
                if (b) {
                    result += 1;
                }

            }
        }
        System.out.println("result = " + result);
    }

    public static boolean DFS(int x, int y) {
        //주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >=m ){
            return false;
        }

        //현재 노드를 아직 방문하지 않았다면 ?
        if (iceBoxGraph[x][y] == 0) {
            //해당 노드 방문 처리
            iceBoxGraph[x][y] = 1;
            //상,하,좌,우의 위치들도 모두 재귀적으로 호출
            DFS(x, y+1); //상
            DFS(x, y-1); //하
            DFS(x-1, y); //좌
            DFS(x+1, y); //우
            return true;
        }
        return false;
    }
}
