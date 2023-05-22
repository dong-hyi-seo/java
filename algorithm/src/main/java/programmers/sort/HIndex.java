package programmers.sort;

import java.util.Arrays;

/**
 * H-Index - Level2
 * URL : {@link : https://school.programmers.co.kr/learn/courses/30/lessons/42747}
 *
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */
public class HIndex {

    /**
     * [3, 0, 6, 1, 5]
     *
     * h=1 1번 이상 인용된 논문이 4개 1개 이하인 논문이 1개
     * h=2 2번 이상 인용된 논문이 3개 2개 이하인 논문이 2개
     * h=3 3번 이상 인용된 논문이 3개 3개 이하인 논문이 3개 3,3,3,3 -> 정답
     * h=4 4번 이상 인용된 논문이 2개 4개 이하인 논문이 3개
     *
     * 정렬 -> [0, 1, 3, 5, 6]
     * h = 6 6번이상 인용된 논문이 6편 이상이고 나머지 논문이 6번 이하 인용? ->false
     * h = 5 5번이상 인용된 논문이 5편 이상이고 나머지 논문이 5번 이하 인용? -> false
     * h = 4 4번이상 인용된 논문이 4편 이상이고 나머지 논문이 4번 이하 인용? -> false
     * h = 3 3번이상 인용된 논문이 3편 이상이고 나머지 논문이 3편 이하 인용 ? -> true
     */
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i=0; i<citations.length; i++) {
            int h = citations.length - i; //거꾸로 큰수부터 체크해보자 큰수부터 하는이유는 최댓값만 뽑으면 되니까!
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
