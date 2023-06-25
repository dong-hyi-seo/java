package programmers.greedy;

import java.util.Arrays;

/**
 * 큰수만들기
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면
 * [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
 * 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중
 * 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 이문제는 1924에서 그 자리 위치에서 두자리를 제거한거지 두자리를 제거하고 각숫자의 자리가
 * 바뀔수는없다 그래서 저 예시중 91이 안되는것이다
 *
 * 제한 조건
 * number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 *
 * combination 알고리즘 (재귀로 조합)
 */
public class MakeBigNumber {

    /**
     * number : 1231234;
     * k = 3;
     * return 3234;
     * 주어진 숫자로 제일큰수는 ? 9421
     * 한개 -> 9 두개 -> 94, 세개 -> 942, 네개 -> 9421
     */
    public String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();

        String[] numberArr = number.split("");
        int combinationNumber = numberArr.length - k;

        Arrays.sort(numberArr, (o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));
        System.out.println("combinationNumber = " + combinationNumber);
        System.out.println("numberArr = " + Arrays.toString(numberArr));

        for (int i=0; i<combinationNumber; i++) {
            answer.append(numberArr[i].toString());
        }

        System.out.println("answer = " + answer.toString());

        return answer.toString();
    }
}
