package programmers;

import java.util.Arrays;

/**
 * 행렬 테두리 회전하기 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=java
 *
 * rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다.
 * 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다.
 * 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.
 *
 * x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
 * 다음은 6 x 6 크기 행렬의 예시입니다.
 *
 * 이 행렬에 (2, 2, 5, 4) 회전을 적용하면,
 * 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다.
 * 이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.
 *
 * 행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns,
 * 그리고 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤,
 * 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * REFER : https://velog.io/@ckr3453/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%96%89%EB%A0%AC-%ED%85%8C%EB%91%90%EB%A6%AC-%ED%9A%8C%EC%A0%84%ED%95%98%EA%B8%B0-Java
 */
public class RotateMatrixBorders {

    /**
     * matrix = 6 * 6
     * int[][] queries = {
     *      {2,2,5,4},
     *      {3,3,6,6},
     *      {5,1,6,3}
     * };
     * 01, 02, 03, 04, 05, 06
     * 07, 08, 09, 10, 11, 12
     * 13, 14, 15, 16, 17, 18
     * 19, 20, 21, 22, 23, 24
     * 25, 26, 27, 28, 29, 30
     * 31, 32, 33, 34, 35, 36
     *
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = initMatrix(rows, columns);


        matrixLog(matrix, "처음");
        int index = 0;
        for(int[] query : queries) {
            int x1 = query[0] - 1; //1
            int y1 = query[1] - 1; //1
            int x2 = query[2] - 1; //4
            int y2 = query[3] - 1; //3

            int firstNum = matrix[x1][y2]; //처음으로 잃어버림..
            int min = firstNum;
            System.out.println("firstNum = " + firstNum);

            /**
             * 매트릭스 상단 우측 이동
             * x, y좌표에서 x는 고정 y는 2, 1 로만 이동
             * y = 3에는 y = 2값을
             * y = 2에는 y = 1값을
             */
            for(int i=y2-1; i>=y1; i--) { //2 ~ 1
                min = Math.min(min, matrix[x1][i]);
                matrix[x1][i+1] = matrix[x1][i];
            }
            matrixLog(matrix, "맨 상단 우측 이동");

            /**
             * 숫자를 위로 이동 (좌측)
             * y는 고정 x만 이동 x는 2 -> 4
             * x = 1 에는 x = 2 값을
             * x = 2 에는 x = 3 값을
             * x = 3 에는 x = 4 값을
             */
            for(int i=x1+1; i<=x2; i++) { // 2 ~ 3
                min = Math.min(min, matrix[i][y1]);
                matrix[i-1][y1] = matrix[i][y1];
            }
            matrixLog(matrix, "맨 좌측 위로 이동");

            /**
             * 숫자를 좌로 이동 (하단)
             */
            for(int i=y1+1; i<=y2; i++) {
                min = Math.min(min, matrix[x2][i]);
                matrix[x2][i-1] = matrix[x2][i];
            }
            matrixLog(matrix, "맨 하단 좌측 이동");

            /**
             * 숫자를 아래로 이동 (우측)
             * x2 = 4, x1 = 1
             * i = 3,
             */
            for(int i=x2-1; i>=x1; i--) {
                min = Math.min(min, matrix[i][y2]);
                matrix[i+1][y2] = matrix[i][y2];
            }
            matrixLog(matrix, "맨 우측 아래로 이동");

            matrix[x1+1][y2] = firstNum;
            answer[index] = min;
            index ++;
            matrixLog(matrix, "완료 ");

        }
        return answer;
    }

    private int[][] initMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int value = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        return matrix;
    }

    private void matrixLog(int[][] matrix, String text) {
        System.out.println("======= " + text + " matrix log =======");
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
