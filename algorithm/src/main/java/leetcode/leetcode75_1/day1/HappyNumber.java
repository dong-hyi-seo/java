package leetcode.leetcode75_1.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * @since 2023.02.21
 * leetcode75 day1
 *
 * 숫자가 n만족스러운지 판단하는 알고리즘을 작성하세요.
 *
 * 행복한 숫자는 다음 프로세스에 의해 정의된 숫자입니다.
 *
 * 양의 정수로 시작하여 해당 숫자의 제곱의 합으로 숫자를 바꿉니다.
 * 숫자가 1이 될 때까지 프로세스를 반복하거나(남을 위치) 1을 포함하지 않는 주기에서 무한 반복합니다 .
 * 이 프로세스가 1로 끝나는 숫자는 행복합니다.
 * 가 행복한 숫자이면 true 반환 하고 그렇지 않으면 를 반환합니다 .n false
 *
 * 예 1:
 * 입력: n = 19
 *  출력: 참
 *  설명:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 예 2:
 * 입력: n = 2
 *  출력: 거짓

 *
 * 제약: 1 <= n <= 2^31 - 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        //set을 cache역할로 준 이유는 주어진 n에 대해서 문제처럼 결과값을 도출하는것이 주기가 존재한다.
        //주기체크용도로 set cache에 존재한다면? false로 리턴하면된다 . 이는 happy number가 아니라는 것이다.
        Set<Integer> cache = new HashSet<>();
        while (!cache.contains(n)) {
            cache.add(n);
            n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            //num > 0보다 클 때까지,
            //num이 19라면,
            //19 -> 19 % 10 = 9, 9 * 9, 1의 자릿수
            //19 / 10, 1 * 1; 10의 자릿수
            //81 + 1;
            //82 -> 82 % 10 = 2, 2 * 2, 1의 자릿수
            //82 / 10 = 8, 8 * 8
            //4 + 64
            //68 -> 68 % 10 = 8, 8 * 8
            //68 / 10 = 6, 6 * 6
            //100, 100 % 10 = 0, 0*0,
            //10, 10 % 10 = 0, 0*0,
            //1, 1 % 10 =1 , 1 * 1
            //1로 떨어짐
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
