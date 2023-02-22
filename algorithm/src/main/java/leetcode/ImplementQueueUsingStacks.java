package leetcode;

import java.util.Stack;

/**
 *
 * @since 2023.02.22
 * URL : https://leetcode.com/problems/implement-queue-using-stacks/
 두 개의 스택만 사용하여 선입선출(FIFO) 대기열을 구현합니다.
구현된 대기열은 일반 대기열의 모든 기능( push, peek, pop, empty)을 지원해야 합니다.

 클래스를 구현합니다 MyQueue.

 void push(int x)요소 x를 큐의 뒤로 푸시합니다.
 int pop()큐 앞에서 요소를 제거하고 반환합니다.
 int peek()큐의 맨 앞에 있는 요소를 반환합니다.
 boolean empty()true대기열이 비어 있으면 반환하고 false그렇지 않으면 반환합니다.
 노트:
 스택의 표준 작업 만 사용해야 합니다 .
즉 push to top, peek/pop from top, size, 및 is empty작업만 유효합니다.
 언어에 따라 스택이 기본적으로 지원되지 않을 수 있습니다.
스택의 표준 작업만 사용하는 한 목록 또는 deque(양단 대기열)를 사용하여 스택을 시뮬레이션할 수 있습니다.


 예 1:
 입력
 ["MyQueue", "push", "push", "peek", "pop", "empty"] [[], [1]
 , [2], [], [], []] 출력
 [null , null, null, 1, 1, false] 설명
 MyQueue myQueue = new MyQueue();
 myQueue.push(1); // 대기열: [1]
 myQueue.push(2); // 대기열: [1, 2](가장 왼쪽이 대기열의 앞)
 myQueue.peek(); // 1 반환
 myQueue.pop(); // 1 반환, 큐는 [2]
 myQueue.empty(); // 거짓 반환

 제약:
 1 <= x <= 9
 대부분의 호출은 , , 및 100 에 이루어집니다
 push,pop,peek,empty, pop및 에 대한 모든 호출이 peek유효합니다.

후속 조치: 각 작업이 시간 복잡도를 상각하도록 대기열을 구현할 수 있습니까 O(1)?
즉, 이러한 작업 중 하나가 더 오래 걸리더라도 n작업을 수행하는 데 전체 시간이 걸립니다 .O(n)
 */
public class ImplementQueueUsingStacks {

    /**
     * 풀이과정
     * inStack 변수는 push받는 그대로 담고있는 역할
     * outStack 변수는 inStack변수를 역순하여 담고있는 역할
     *
     * MyQueue에서 pop은 outStack에서 pop을 하며 queue의 fifo 역할을 하게된다.
     */
    static class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        //꺼내서 제거
        public int pop() {
            // outStack 이 비었다면 ? inStack에 있는애들로 역순하여 동기화
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            // outStack 이 비었다면 ? inStack에 있는애들로 역순하여 동기화
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
