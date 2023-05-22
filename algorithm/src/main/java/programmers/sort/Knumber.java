package programmers.sort;

import java.util.Arrays;

/**
 * K번째 수 - Level1
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 */
public class Knumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1] - 1;
            int select = commands[i][2] - 1;
            int[] tempArr = Arrays.copyOfRange(array, from, to+1);
            Arrays.sort(tempArr);
            answer[i] = tempArr[select];
        }
        return answer;
    }
}
