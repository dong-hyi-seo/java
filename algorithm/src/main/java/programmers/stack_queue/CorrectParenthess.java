package programmers.stack_queue;

import java.util.Stack;

/**
 * 올바른 괄호
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParenthess {
    public boolean solution(String s) {

        String open = "(";
        String close = ")";

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        if (!Character.toString(first).equals(open)) {
            return false;
        }
        if (!Character.toString(last).equals(close)) {
            return false;
        }
        //stack 전환
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char d = s.charAt(i);
            stack.push(Character.toString(d));
        }

        //반드시
        int count = 0;
        while (!stack.empty()) {
            String str = stack.pop();
            if (str.equals(")")) {
                count++;
            } else {
                count--;
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
}
