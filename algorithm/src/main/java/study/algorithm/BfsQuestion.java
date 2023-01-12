package study.algorithm;

/**
 * - 동빈이는 N * M 크기의 직사각형 형태의 미로에 갇혓습니다. 미로에는 여러마리의 괴물이 있어 이를 피해 탈출해야 한다.
 *
 * - 동빈이의 위치는 (1, 1)이며 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있습니다.
 * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있습니다.
 * 미로는 반드시 탈출할 수 있는 형태로 제시됩니다.
 *
 * - 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하세요.
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다.
 *
 * - 입력조건 : 첫째 줄에 두 정수, N, M(4≤N, M≤200)이 주어집니다.
 * 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어집니다.
 * 각각의 수들은 공백 없이 붙어서 입력으로 제시됩니다. 또한 시작칸과 마지막 칸은 항상 1입니다.
 *
 * - 출력조건 : 첫째 줄에 최소 이동 칸의 개수를 출력합니다.
 */
public class BfsQuestion {

    private final static int n = 5;
    private final static int m = 6;
    private final static int[][] miroGraph = {
            {1,0,1,0,1,0},
            {1,1,1,1,1,1},
            {0,0,0,0,0,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
    };

    public static void main(String[] args) {

        int result = 0;
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {

            }
        }
        System.out.println("result = " + result);
    }

    public static int DFS(int x, int y) {
        return 0;
    }
}
