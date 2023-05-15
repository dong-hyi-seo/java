package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 의상 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Costume {

    public int solution(String[][] clothes) {
        //옷을 종류별로 구분
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        //입지 않는 경우 ?
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next() + 1; //각 종류별에 대하여 안입는 경우가 있기 때문에 +1을 해줘서 경우의수를 구한다.

        return answer - 1; //하지만 전제가 아무것도 입지 않는 것은 허용되지 않기때문에 -1을 해준다.
    }
}
