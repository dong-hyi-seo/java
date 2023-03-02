package leetcode.leetcode75.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @since 2023.02.27
 * URL : https://leetcode.com/problems/multiply-strings/?envType=study-plan&id=level-2
 * 43. Multiply Strings
 * 문자열로 표현된 두 개의 음이 아닌 정수 num1과 num2가 주어지면 역시 문자열로 표현되는 num1과 num2의 곱을 반환합니다.
 * 참고:  내장 BigInteger 라이브러리를 사용하거나 입력을 직접 정수로 변환하면 안 됩니다.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * 123
 * 456
 * Output: "56088"
 *
 * 제약:
 * 1 <= num1.length, num2.length <= 200
 * num1num2숫자로만 구성됩니다 .
 * 둘 num1다 num2 숫자 0자체를 제외하고 선행 0을 포함하지 않습니다.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] arr = new int[num1.length() + num2.length()];

        for (int i=num1.length()-1; i >= 0; i--) {
            for (int j=num2.length()-1; j>=0; j--) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i + j] += arr[i+j+1]/10;
                arr[i+j+1] %= 10;
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
        StringBuilder str = new StringBuilder();
        for (int i=0; i<num1.length() + num2.length(); i++) {
            if (i == 0) {
                if (arr[i] == 0) {
                    continue;
                }
            }
            str.append(arr[i]);

        }

        return str.toString();
    }
}
