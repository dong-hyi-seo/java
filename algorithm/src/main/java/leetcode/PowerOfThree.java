package leetcode;

/**
 * @author donghyi.seo
 * @since 2022-08-24
 * Power of Three
 * URL : https://leetcode.com/problems/power-of-three/
 *
 * Given an integer n, return true if it is a power of three.
 * (정수 n이 주어지면 3의 거듭제곱이면 true를 반환 한다)
 * Otherwise, return false.
 * (그렇지 않으면 false를 반환)
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * (정수 n은 n == 3x인 정수x가 존재하는 경우 3의 거듭제곱이다.)
 *
 * Example 1:
 * Input: n = 27
 * Output: true
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 * Example 3:
 *
 * Input: n = 9
 * Output: true
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 */
public class PowerOfThree {

    public boolean mySolution(int n) {
        if (n < 1) {
          return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
