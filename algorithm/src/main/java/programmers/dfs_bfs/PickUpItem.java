package programmers.dfs_bfs;

/**
 * 아이템 줍기 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */
public class PickUpItem {

    /**
     * 왼쪽하단, 왼쪽상단, 오른쪽하단, 오른쪽상단
     * {1,1,7,4}, -> {1,1}, {1,4}, {7,1}, {7,4}
     * {3,2,5,5},
     * {4,3,6,9},
     * {2,6,8,8};
     *
     * int characterX = 1;
     * int characterY = 3;
     * int itemX = 7;
     * int itemY = 8;
     *
     * 상,하,좌,우 갈수있는지 ?
     * 네방향갔을때 사각형 범위내에 포함이 되는지?
     *
     * {1,3} 위로이동 {1, 4} 이좌표가 {1,1}, {1,4} 범위 안인지? 1 < y <= 4 = true
     * 아래로 이동 {1, 2} 1 < y <= 4 이내
     */
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        return answer;
    }

    public static void BFS() {

    }

    //사각형 정보 생성


    //이동하는 좌표가 사각형 내부인지 ?
}
