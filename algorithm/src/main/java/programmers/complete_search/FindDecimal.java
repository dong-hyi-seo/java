package programmers.complete_search;

import java.util.HashSet;

/**
 * 소수찾기 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 소수 : 1보다 큰 정수 1과 자기 자신으로만 나누어지는 수로 영어로는 Prime Number라고 한다.
 * 1은 1보다 큰정수가 아니므로 소수가 아니다.
 * 2는 1보다 큰 정수이고 1과 2이외의 자연수로 나눌 수 없으므로 소수이다.
 * 4는 1보다 큰 정수이지만 1과 4이외에도 2로 나누는 것이 가능하므로 소수가 아니다.
 * 5는 1보다 큰정수이고 1과 5이외의 자연수로 나눌 수 없으므로 소수이다.
 *
 * 소수찾기 방식 에라토스테네스의 체 활용
 * 소수 = 1제외, N의 제곱근보다 작은 소수의 배수를 모두 지우고 남은수
 */
public class FindDecimal {

    //모든 숫자 조합은 중복될수 없기때문에 set 자료구조를 사용한다.
    private static final HashSet<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        //주어진 카드숫자로 만들수있는 모든 수를 만든다.(완전탐색)
        recursive("", numbers);
        System.out.println("numberSet = " +numberSet);

        //위에서 주어진 카드로 모둔 숫자를 만든 배열을 소수인지 체크해서 소수이면 카운트해서 return하면됨


        return answer;
    }

    /**
     * combine 조합했던 숫자
     * others는 남은 숫자
     * 1.
     * comb = "" others = 171
     * i=0 comb = 1
     * comb는 처음에 1과 [7,1]의 조합 재귀돌리고
     * comb는 두번째 7과 [1,1]의 조합 재귀를 돌리고
     */
    public void recursive(String comb, String others) {
        System.out.println("========= recursive ============");
        System.out.println("comb = " + comb + " // others = " + others);
        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals("")) //조합한 숫자가 있으면 set에 담는다.
            numberSet.add(Integer.valueOf(comb));

        if (others.length() == 0) {
            System.out.println("======= 하나의 combs에 대해 종료 =======");
            return;
        }
        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        //
        for (int i = 0; i < others.length(); i++) {
            System.out.println("i = " + i + " // comb = " + comb + " // others = " + others);
            System.out.println("comb + others.charAt(i) = " +comb + others.charAt(i));
            System.out.println("others.substring(0, i) = " +others.substring(0, i));
            System.out.println("others.substring(i + 1) = " +others.substring(i + 1));
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }


    }

    private boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        //제곱근을 구한다 나눌수있는 범위까지만 반복문을 돌기위해
        //10의 제곱근은  정수 3으로 하기때문에 2~3까지만 돌고 판단하면됨
        int lim = (int) Math.sqrt(number);

        for (int i = 2; i < lim; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
