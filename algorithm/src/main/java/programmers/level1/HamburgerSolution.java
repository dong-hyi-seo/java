package programmers.level1;

import java.util.Stack;

/**
 * @author donghyi.seo
 * @since 2022-12-22
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/133502
 *
 * 문제 설명
 * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
 * 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
 * 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
 * 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
 * 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
 * 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
 *
 * 예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때,
 * 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고,
 * 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
 *
 * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때,
 * 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 *
 * 제한사항
 * 1 ≤ ingredient의 길이 ≤ 1,000,000
 * ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
 * 입출력 예
 * ingredient	result
 * [2, 1, 1, 2, 3, 1, 2, 3, 1]	2
 * [1, 3, 2, 1, 2, 1, 3, 1, 2]	0
 */
public class HamburgerSolution {
    /**
     * [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]
     * 해당 솔루션은 프로그래머스에서 시간초과 나옴
     */
    public int mySolution(int[] ingredient) {
        int answer = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int value : ingredient) {
            stringBuilder.append(value);
        }
        String ingredientStr = stringBuilder.toString();
        boolean is = true;
        while(is) {
            if (ingredientStr.contains("1231")) {
                ingredientStr = ingredientStr
                        .replaceFirst("1231", "");
                answer ++;
            } else{
                is = false;

            }
        }
        return answer;
    }

    /**
     * 시간초과로 인하여 다른 솔루션 풀이
     * 참조 : https://velog.io/@reasonz/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%96%84%EB%B2%84%EA%B1%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0JS
     */
    public int anotherSolution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int in : ingredient) {
            stack.push(in);

            //사이즈 4일경우 (계속 4개씩 체크)
            if (stack.size() >= 4){
                System.out.println("stack = " + stack);
                if (stack.get(stack.size() - 4) == 1
                && stack.get(stack.size()-3) == 2
                && stack.get(stack.size()-2) == 3
                && stack.get(stack.size()-1) == 1
                ) {
                    //1231이 맞으면 카운트 해주고 pop로제거
                    answer ++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }

}
