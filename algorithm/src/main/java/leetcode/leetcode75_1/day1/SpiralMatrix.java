package leetcode.leetcode75_1.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2023.02.21
 * URL : https://leetcode.com/problems/spiral-matrix/?envType=study-plan&id=level-2
 * 주어진 이중 배열 매트릭스에서 순서대로 뽑아서 일차원 배열로 리턴
 *
 * 예제 1
 * input : [[1,2,3],[4,5,6],[7,8,9]]
 * 1, 2, 3
 * 4, 5, 6
 * 7, 8, 9
 * output : [1,2,3,6,9,8,7,4,5]
 *
 * 예제2
 * input : [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 1, 2, 3, 4
 * 5, 6, 7, 8
 * 9, 10, 11, 12
 * output : [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 1, 2, 3, 4
 * 5, 6, 7, 8
 * 9, 10, 11, 12
 * 13, 14, 15, 16
 * output : [1,2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 *
 * {1,2,3,4},
 * {5,6,7,8},
 * {9,10,11,12},
 * {13,14,15,16}

 *
 *
 * 제약조건
 * m : 가로개수, n : 세로개수
 * m == matrix.length;
 * n == matrix[i].length;
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100 (각 배열의 원소는 -100 이상 100이하
 */
public class SpiralMatrix {

    /**
     * DFS
     * 1. 갈수 있는 방향 선정
     *  - 상,하,좌,우 체크
     *  - 첫번째 [0][0]의 우: [0][1], 하: [1][0]
     *  - 두번째 [0][1]의 좌 : [0][0] 우 : [0][2], 하 : [1][1]
     *  - 상 : 첫번째 index - 1
     *  - 하 : 첫번째 index + 1
     *  - 좌 : 두번째 index - 1
     *  - 우 : 두번째 index + 1
     *
     *  그렇다면 상,하,좌,우 중 우선권은? 우(동),하(남),좌(서),상(북) 순이다.
     * 2. 한번 방문한곳 표시 해당 index요소를 -1로 치환하여자 들렸다라는 것을 체크해준다.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answerList = new ArrayList<>();

        /**
         * 1, 2, 3, 4
         * 5, 6, 7, 8
         * 9, 10, 11, 12
         */
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        //언제까지 돌아야하나 ?
        //while(top <= bottom && left <= right){
        while (top <= bottom && left <= right) {

            //왼쪽에서 오른쪽으로 쭉가자 ~
            System.out.println("============");
            System.out.println("왼쪽에서 오른쪽으로 ! left : " + left + " ~> bottom : " +right );
            for (int i=left; i<=right; i++) {
                System.out.println("왼 -> 오 : " + matrix[top][i]);
                answerList.add(matrix[top][i]);
            }

            //그다음 행으로 이동해야하니 top ++

            //위에서 아래로 가볼까 ?~
            top ++;
            System.out.println("============");
            System.out.println("위에서 아래로 ! top : " + top + " ~> bottom : " +bottom );
            for (int i=top; i<=bottom; i++) {
                System.out.println("위 -> 아 : " + matrix[i][right]);
                answerList.add(matrix[i][right]);
            }

            //그다음은 오른쪽에서 왼쪽으로 쭉 가볼까~
            right--;
            System.out.println("============");
            System.out.println("오른쪽에서 왼쪽 ! right : " + right + " ~> left : " +left  + " // top : " + top + " // bottom : " + bottom);
            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    System.out.println("오 -> 왼 : " + matrix[bottom][i]);
                    answerList.add(matrix[bottom][i]);
                }
            }


            //그다음은 아래에서 위쪽으로 가보
            bottom--;
            System.out.println("============");
            System.out.println("아래에서 위쪽 ! bottom : " + bottom + " ~> top : " + top + " // left : " + left + " // right : " + right);
            if (left <= right) {
                for (int i=bottom; i>=top; i--) {
                    System.out.println("아 -> 위 : " + matrix[i][left]);
                    answerList.add(matrix[i][left]);
                }
            }
            left++;
        }
        System.out.println("answerList = " + answerList);
        return answerList;
    }
}
