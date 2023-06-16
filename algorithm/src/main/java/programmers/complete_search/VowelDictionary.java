package programmers.complete_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 모음사전
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *
 * 문제 설명
 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
 * 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고,
 * 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 *
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 * word	result
 * "AAAAE"	6
 * "AAAE"	10
 * "I"	1563
 * "EIO"	1189
 */
public class VowelDictionary {

    static final String[] WORDS = {"A", "E", "I", "O", "U"};
    static final List<String> list = new ArrayList<>();
    static final int MAX_LENGTH = 5;

    public int solution(String word) {
        int answer = 0;

        //list 의 모든 문자에대산 것을 담아준다.
        dfs("", 0);

        //모든 문자가 담겨진 list에서 찾고자하는 word를 찾아 해당 word가 몇번째에 있는지 찾는다.
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        list.add(str);
        if (len == MAX_LENGTH) return;
        for (int i = 0; i < MAX_LENGTH; i++) {
            dfs(str + WORDS[i], len + 1);
        }
    }
}
