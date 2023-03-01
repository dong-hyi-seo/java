package leetcode.leetcode75.day2;

import java.util.ArrayList;
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

        List<String> addTargetList = getAddTargetList(num1, num2);
        String target = addTargetList.get(0);
        for (int a = addTargetList.size() - 1; a>=1; a--) {
            add(target, addTargetList.get(a));
        }
    }

    private String add(String num1, String num2) {

        return target;
    }
    private List<String> getAddTargetList(String num1, String num2) {
        List<String> addTargetList = new ArrayList<>();
        for (int a = num2.length()-1; a >= 0; a--) {
            List<Integer> list = new ArrayList<>();
            int carry = 0;
            int nn = (int) num2.charAt(a) - 48; //일의 자리 뽑기

            System.out.println("a = " + a + " // nn = " + nn);
            for (int b = num1.length()-1; b>=0; b-- ) {
                int mm = (int) num1.charAt(b) - 48;
                System.out.println(nn + " * " + mm);
                int r = (nn * mm) + carry;
                int c = 0;
                if (b == 0) { //맨마지막계산은?
                    c = r;
                } else {
                    c = r % 10; //나머지가 자리를 매김하고
                    carry = r / 10; //몫이 그다음자리로 넘어감
                }
                list.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for (int index=list.size() - 1; index >=0; index--) {
                sb.append(list.get(index));
            }
            for (int y=0; y<num2.length()-1-a; y++) {
                sb.append(0);
            }
            addTargetList.add(sb.toString());
        }
        return addTargetList;
    }
}
