package study.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 순열관련 (주어진 n 요소들의 모든 경우의 수를 꼐산하는 방법 / O(n!) 시간복잡도
 * 백트래킹 요소
 * - 선택 (우리가 내려야할 결정)
 * - 제약
 * - 목표에 도달
 */
public class Permutation {
    /**
     * [a, b, c]
     * 이중포문 i, j [i, 0], [i, 1], [i,2] 스왑
     * 3P3 3개숫자중 3개조합의 순열
     */


    public static void main(String[] args) {
        int n = 3;
        int r = 3;
        int[] data = {1, 2, 3};
        boolean[] visited = new boolean[n];
        int[] result = new int[n];

        //원본 데이터, 담을 데이터, 방문했는지 체크 배열, 깊이, 최종도달지점
        dfs(data, result, visited, 0, 3);

    }

    static void dfs(int[] arr, int[] output, boolean[] visited, int depth, int r) {

        if (depth == r) { //목표도달 (dfs에서 최대깊이만 큼 도달한경우) -> 종료조건 !!
            System.out.println("output = " + Arrays.toString(output));
            return;
        }
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(arr, output, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }

    /**
     * backtracking
     * void Backtrack(res, args)
     *  if (GOAL 도착)
     *      add solution to res
     *      return
 *      for (int i=0; i < NB_CHOICES; i++)
     *      if (CHOICES[i] os valid)
     *          make choices[i]
     *          Backtrack(res, args)
     *          undo choices[i[
     */

}
