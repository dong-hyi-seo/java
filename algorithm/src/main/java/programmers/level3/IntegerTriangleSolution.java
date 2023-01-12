package programmers.level3;

import java.util.Arrays;

/**
 * @author donghyi.seo
 * @since 2022-12-19
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43105

 *
 * 정수 삼각형
 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다.
예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

 제한사항
 삼각형의 높이는 1 이상 500 이하입니다.
 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
 입출력 예
 triangle	result
 [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30

 7 + 3 + 8 + 7 + 5

 해당문제 풀떄 https://www.notion.so/Dynamic-programming-0354ddcc7ba340d59482673b1828fb45
 */
public class IntegerTriangleSolution {
    /**
     * 삼각형의 첫행부터 각 행까지의 누적 해놓은 합산 값을 이차원 배열에 저장하는 방식으로하여 중복연산을 막자
     * 주어진 문제 삼각형
     * 7
     * 3, 8
     * 8, 1, 0
     * 2, 7, 4, 4
     * 4, 5, 2, 6, 5
     *
     *
     */
    public int mySolution(int[][] triangle) {
        final int totalRowCnt = triangle.length;
        int answer = 0;

        int[][] dp = new int[totalRowCnt][totalRowCnt];
        //첫줄 dp 담기
        dp[0][0] = triangle[0][0];
        for (int i=1; i<triangle.length; i++) {
            //맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            //중간... 중간값은 두번씩 연산하여 비교하여 max값만 Dp에 담아준다.
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }

            //끝
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        answer = Arrays.stream(dp[totalRowCnt-1]).max().orElse(0);
        return answer;
    }
}
