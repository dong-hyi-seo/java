package programmers.hash;

import java.util.HashMap;

/**
 * 전화번호목록 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (int i=0; i<phone_book.length; i++) {
            for (int j=1; j<phone_book[i].length(); j++) {
                String checkStr = phone_book[i].substring(0, j);
                if (map.containsKey(checkStr)) return false;
            }
        }
        return answer;
    }

}
