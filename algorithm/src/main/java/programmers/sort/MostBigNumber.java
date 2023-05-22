package programmers.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 가장 큰수 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
 * 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 */
public class MostBigNumber {

    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        System.out.println("before list = " + list);
        list.sort((a, b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            System.out.println("======");
            System.out.println("as = " + as);
            System.out.println("bs = " + bs);
            System.out.println("Integer.parseInt(as + bs) = " + Integer.parseInt(as + bs));
            System.out.println("Integer.parseInt(bs + as) = " + Integer.parseInt(bs + as));
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        System.out.println("after list = " + list);
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        String answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}
