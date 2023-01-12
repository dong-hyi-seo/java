package programmers.level2;

import java.util.Arrays;

/**
 * @author donghyi.seo
 * @since 2022-11-12
 * URL :https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */
public class HanoiTopSolution {

    private int index = 0;

    public static void main(String[] args) {
        HanoiTopSolution hanoiTopSolution = new HanoiTopSolution();
        hanoiTopSolution.mySolution(4);
    }
    /**
     * 하노이의 탑 이동횟수 2^n - 1
     * @param n : 총원반의 개수
     * 나의 솔루션
     * 재귀함수 활용
     * - 종료조건을 설정
     * - 문제의 정의를 선언
     *  - N개의 원반을 옮기기 위해서는 N-1개의 원반을 이웃한 기둥으로 옮겨야한다.
     *  - 가장 큰 원반이 최종 목적 기둥으로 옮긴다.
     *  - 이제 이우한 기둥에서 N-1개의 원반을 최종 목적 기둥으로 올겨야한다.
     *  - 제일 큰 원반이 목표기둥으로 옮겨지면 N-1개부터 다시 시작하면 된다. 즉 제일큰원반 위에 나머지 원반 아무거나 위에 둘수있으므로 목표 기둥에 원반의 개수는 무시한다.
     *  - 원반을 목표 기둥에 옮긴 후 전에 사용하던 보조기둥이 시작기둥으로 원래 시작기둥이 보조기둥으로 역할이 변겨된다.
     *
     * hanoi(5, 1, 3, 2)
     *  - 다섯개의 원판을 1전 기둥에서 3번기둥으로 옮기는데 2번 기둥을 보조로 사용하겠다.
     * hanoi(원반개수 -1, 시작, 보조, 목표)
     *  - N개의 원반일때 N-1개의 원반은 보조기둥으로 옮겨야한다.
     * hanoi(원반개수 - 1. 보조, 시작, 목표)
     */
    public int[][] mySolution(int n) {
        System.out.println("n = " + n);
        int[][] answer = new int[(int)Math.pow(2, n) - 1][2];
        hanoi(n, 1, 3, 2, answer);
        System.out.println("answer = " + Arrays.deepToString(answer));
        return answer;
    }

    /**
     *
     * @param n 총원반 개수
     * @param from 옮기고자 하는 원반의 출발 기둥
     * @param to 원반의 목표 기둥
     * @param sub 원반을 옮길때 보조로 사용할 기둥
     */
    public void hanoi(int n, int from, int to, int sub, int[][] answer) {
        int[] move = {from ,to};
        if (n == 1) {
            System.out.println("start(" + from + ") -> target(" + to + ")");
            answer[index++] = move;
        } else {
            hanoi(n-1, from, sub, to, answer); //가장 큰 링을 제외한 나머지를 보조 막대로 이동
            System.out.println("start(" + from + ") -> target(" + to + ")");
            answer[index++] = move; //최종 가장 큰 링을 기존 기둥에서 목표 기둥으로 옮긴다.
            hanoi(n-1, sub, to, from, answer);  //하노이의탑을 다시 반보간다 (n-1) 에대해서
            //대신 시작이 보조기둥이 됨. 왜냐 보조기둥에 쌓여있을테니!! 그럼 기존 보조기둥의 역할은 시작이되고 시작기둥의 역할이 보조기둥역할이됨
        }
    }

}
