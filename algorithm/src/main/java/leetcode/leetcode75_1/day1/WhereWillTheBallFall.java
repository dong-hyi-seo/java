package leetcode.leetcode75_1.day1;

import java.util.Arrays;

/**
 * @since 2023.02.27
 * URL : https://leetcode.com/problems/where-will-the-ball-fall/?envType=study-plan&id=level-2
 *
 * [
 * [1,1,1,-1,-1],
 * [1,1,1,-1,-1],
 * [-1,-1,-1,1,1],
 * [1 ,1,1,1,-1],
 * [-1,-1,-1,-1,-1]
 * ]
 *
 * - 탈출 조건
 * 1. 자기 행의 다음 index와 합이 0이아니여야함
 * 같은 행에 특정 열이 1이고 그다음열이 -1 이면 상자소에 갇힌다.
 */
public class WhereWillTheBallFall {

    /**
     * DFS
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        int[] existCol = new int[grid[0].length];
        for (int col=0; col<grid[0].length; col ++) {
            System.out.println("=======================");
            System.out.println(col + " 번째 공 DFS 시작!");
            existCol[col] = dfs(grid, 0, col);
        }
        System.out.println("existCol = " + Arrays.toString(existCol));
        return existCol;
    }

    private int dfs(int[][] grid, int row, int col) {

        System.out.println("row = " + row + " // col = " + col);
        //공이 상자 끝에 도달
        if (row == grid.length) {
            return col;
        }

        //성공적으로 공전달
        if (grid[row][col] == 1) { //현재 상자에 방향이 오른쪽일경우 그다음열도 오른쪽이면 통과다 반대면 v pattern

            //맨마지막 열에서 오른쪽 방향으로 가게되면 왼쪽 벽에 닿으므로 실패 ??
            if (col == grid[0].length - 1 || grid[row][col+1] == -1) {
                return -1;
            } else {
                //오른쪽방향으로 성공저으로 이동할경우 다음행의 다음열을 체크해야함
                return dfs(grid, row+1, col+1);
            }

        } else { //현재상자에서 방향이 왼쪽일경우 그다음열도 왼쪽이면 통과다 반대면 v pattenr
            if (col == 0 || grid[row][col-1] == 1){
                return -1;
            } else {
                return dfs(grid, row+1, col-1);
            }
        }
    }

}
