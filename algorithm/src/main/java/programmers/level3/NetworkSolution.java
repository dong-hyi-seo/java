package programmers.level3;

import java.util.Arrays;

/**
 * @author donghyi.seo
 * @since 2022-01-05
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 네트워크
 * 문제 설명
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 * 입출력 예
 * n	computers	return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
public class NetworkSolution {

    static int[] ch;
    public int mySolution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];
        for (int i=0; i<n; i++) {
            //첫번째 컴퓨터 방문안했으면 DFS 돈다
            //만약 i 번쨰가 방문이 되었다(1)면 어느 한 네트워크그룹에 속했 있다는 뜻으로 수행하지않는다.
            if (ch[i] == 0) {
                DFS(i, ch, computers);
                answer ++;
            }

        }
        return answer;
    }


    public static void DFS(int target, int[] ch, int[][] computers) {
        ch[target] = 1; //해당 컴퓨터 노드 방문 완료!
        for (int i=0; i<computers.length; i++) {

            //연결 되었다는 조건 ?
            //자기자신이 아니면서
            //자기 자신정보배열 연결된 노드
            //방문한적이 없는 노드
            if (target != i && computers[target][i] == 1 && ch[i] == 0) {
                DFS(i, ch, computers);
            }
        }

    }
}
