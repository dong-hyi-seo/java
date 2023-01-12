package programmers.level3;

import java.util.*;

/**
 * @author donghyi.seo
 * @since 2022-12-29
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42895
 *
 * N으로 표현
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 *
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 *
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중
 * N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 *
 * 제한사항
 * N은 1 이상 9 이하입니다.
 * number는 1 이상 32,000 이하입니다.
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
 * 최솟값이 8보다 크면 -1을 return 합니다.
 * 입출력 예
 * N	number	return
 * 5	12	4
 * 2	11	3
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 *
 */
public class Npresentation {
    static int answer = -1;

    /**
     * 참조 : https://theamabile.tistory.com/24
     */
    public int mySolution(int N, int number) {

        // 1-8번까지의 N사 용 횟수별로 만들 수 있는 모든 수를 중복없이 저장

        //1개로 만들 수있는건 나 자신뿐이다.
        if (number == N) {
            return 1;
        }

        Set<Integer>[] set = new HashSet[9]; // 0번은 편의상 미사용
        int n = 0;
        // 초기화 (1~8까지 n의 연속수를 넣어줌 - ex) 5,55,555,5555,...
        for (int i = 1; i < 9; i++) {
            n = (n * 10) + N;
            set[i] = new HashSet<>();
            set[i].add(n);
        }

        // 이전 연산들을 이용해서 모든 경우를 만들어줌
        for (int i = 1; i <= 8; i++) { // 2번째부터 ~ 8번째까지 만들어줄꺼임 (1번은 n만 들어가므로 이미 완선된 상태)
            for (int j = 1; j < i; j++) { // 1번째(n)부터 만들어주고자하는 set배열 밑에 번호까지의 조합을 전부 add
                for (Integer a : set[j]) { // j번째와
                    for (Integer b : set[i - j]) { // i-j번째의 사칙연산의 조합을 저장
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        // 나눗셈만 연산자 우선순위를 고려해야하므로 두가지 경우로 연산
                        if (b != 0) {
                            set[i].add(a / b);
                        }
                        if (a != 0) {
                            set[i].add(b / a);
                        }
                    }
                }
            }
            if (set[i].contains(number)) {
                answer = i;
                return answer;
            }
        }
        return -1;
    }
}
