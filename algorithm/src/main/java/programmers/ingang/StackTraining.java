package programmers.ingang;

import java.util.Arrays;
import java.util.Stack;

/**
 * stack
 * 뒤에서부터 꺼낸다. 즉 제일 늦게 들어간 놈이 먼저 나온다 (LIFO - Last In First Out)
 * 제공하는 함수 설명!
 * ush() -> 데이터를 넣는다
 * pop() -> 데이터를 꺼낸다
 * peek() -> 데이터를 확인만한다.
 */
public class StackTraining {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        //뒤에서부터 꺼낸다
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }

    /**
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     *
     * "()()" 또는 "(())()" 는 올바른 괄호입니다.
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 문자열 s의 길이 : 100,000 이하의 자연수
     * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
     */
    public boolean bracketMySolution(String s) {
        //s = "(())()"
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }

            //닫는 괄호 여는 괄호와 짝이 맞을경우 그만큼 제거되기때문에 사이즈가 0이될것이다!)
            if (c == ')') {
                if (stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() != 0) answer = false;
        return answer;
    }

    /**
     * 문제 설명
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
     * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록
     * solution 함수를 완성하세요.
     *
     * 제한사항
     * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     * prices의 길이는 2 이상 100,000 이하입니다.
     * 입출력 예
     * prices	return
     * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
     *
     * 입출력 예 설명
     * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
     * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
     * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
     * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
     * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     */
    public int[] stockMySolution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        //[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
        //이문제는 prices 배열에서 순차적으로 꺼내 stack에 넣으면서 비교한다.
        //비교 조건에 맞을때 가장 최근에 들어간 시점을 꺼내기 떄문에(stack) 제일 먼저 들어온 주식이 몇초동안 떨어졌는지 구할수있다.
        for (int i=0; i < prices.length; i++) {
            //stack이 비어있지 않고 target 주식 가격이 하락할때까지 (문제는 몇초까지 떨어지지 않았느냐니까!!)

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                System.out.println("중간에 가격이 떨어진 pirces 배열의 index = " +stack.peek());
                answer[stack.peek()] = i - stack.peek(); //3-2
                stack.pop();
            }
            stack.push(i); //i를 넣는이유는 index 정보를 넣기위함
        }

        //answer에서 값을 구하지 못한 index 위치는 끝까지 가격이 떨어지지 않는 주식이다
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public int[] stockAnotherSolution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            int targetPrice = prices[i];
            int cnt = 0;
            for (int a=i+1; a<prices.length; a++) {
                cnt++;
                if (targetPrice > prices[a]) {
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
