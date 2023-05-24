package programmers.complete_search;

/**
 * 최소 직사각형 - Level1
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class LeastRectangle {
    /**
     * 가로, 세로 길이에 대해서 모든 명함이 수납가능하려면
     * 가로 세로중 제일 큰값과 가로 세로중 제일작은값에서 큰값을 찾으면
     * 최소 범위내에 모든 명함이 허용된다.
     */
    public int solution(int[][] sizes) {
        int answer = 0;

        int max = 0;
        int min = 0;
        for (int[] size : sizes) {
            int paramMax = Math.max(size[0], size[1]);
            int paramMin = Math.min(size[0], size[1]);

            if (paramMax > max) {
                max = paramMax;
            }
            if (paramMin > min) {
                min = paramMin;
            }
        }
        answer = max * min;
        return answer;
    }
}
