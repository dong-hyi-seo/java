package programmers.stack_queue;

import java.util.ArrayList;

/**
 * 같은 숫자는 싫어 - Level1
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class HateTheSameNumber {

    public int[] solution(int []arr) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int value = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != value) {
                answerList.add(arr[i]);
                value = arr[i];
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }
}
