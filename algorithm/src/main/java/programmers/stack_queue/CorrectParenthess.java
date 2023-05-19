package programmers.stack_queue;

import java.util.Stack;

/**
 * 올바른 괄호 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 *  "())(()"
 */
public class CorrectParenthess {
    public boolean solution(String s) {
        //stack 전환
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char d = s.charAt(i);
            if (d == '(') {
                stack.push(d);
            }
            if (d == ')') {
                if (stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;

    }
}
