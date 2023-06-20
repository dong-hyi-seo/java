package programmers.dp;

import java.util.Arrays;

/**
 * 등굣길 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 *
 * 계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다.
 * 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
 * 아래 그림은 m = 4, n = 3 인 경우입니다.
 *
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래,
 * 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.
 *
 * 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다.
 * 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를
 * 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
 * m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * 물에 잠긴 지역은 0개 이상 10개 이하입니다.
 * 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
 */
public class TheWayToSchool {

    /**
     *
     * @param m = 4 가로 (열의갯수)
     * @param n = 3 세로 (가로갯수)
     * @param puddles = [[2, 2]]
     * @return 4;
     *
     * 1. 집, 학교, 웅덩이 위치
     * 집 위치 : [1, 1]
     * 학교 위치 : [m, n]
     * 물 웅덩이 위치 : [[2,2]]
     *
     * 2. 물웅덩이 잠긴지역을 피해서 가는 최단경로의 개수
     * [1, 1, 1, 1]
     * [1, -1, 1, 1]
     * [1, 1, 1, 1]
     */
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int[][] dp = new int[n+1][m+1];
        /**
         * dp 이차원 배열에 웅덩이 할당한다.
         * 소스를보면 반대로 하는데 문제에 m, n으로 설명하지만 가로는 n 세로는 m이므로
         * 웅덩이도 반대로 해서 할당해준다.
         */
        for (int[] puddle: puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        //출발지점 1로 초기화
        dp[1][1] = 1;
        System.out.println("dp = " + Arrays.deepToString(dp));

        /**
         * [0, 0, 0, 0, 0]
         * [0, 1, 0, 0, 0]
         * [0, 0, -1, 0, 0]
         * [0, 0, 0, 0, 0]
         */
        for(int row=1; row<n+1; row++) {
            for (int col=1; col<m+1; col++) {
                /**
                 * 1. row = 2, col = 1
                 * dp[1][1] == 1 ->
                 * dp[2][0] == 0
                 *
                 * 2. row = 1, col = 2
                 * dp[0][2]
                 */
                //웅덩이를 만났을때? 다른루트!
                if(dp[row][col] == -1) {
                    continue;
                }
                if(dp[row-1][col] > 0) dp[row][col] += dp[row-1][col] % mod;
                if(dp[row][col - 1] > 0) dp[row][col] += dp[row][col - 1] % mod;
            }
        }

        return answer;
    }

}
