package programmers.level2;

import java.util.*;

/**
 * @author donghyi.seo
 * @since 2022-11-08
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class OneCacheSolution {

    /**
     * array list로 푼 함수
     */
    public int myOneCacheSolution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) { //캐시크기가 0이면 cache miss 가 cities length만큼 됨
            return cities.length * 5;
        }
        List<String> cache = new ArrayList<>();
        for (int i=0; i<cities.length; i++) {
            //cache hit
            String findCity = cities[i].toLowerCase();
            if (cache.contains(findCity)) { //cache hit
                //hit 됬으니 맨 앞으로 이동!
                cache.remove(findCity);
                cache.add(findCity);
                answer += 1;
            } else { //cache miss
                //만야 cache에 꽉찼으면 ?
                if (cache.size() == cacheSize) {
                    //맨뒤 삭제
                    cache.remove(0);
                    //맨앞에 findCity 넣음
                    cache.add(findCity);
                } else {
                    //cache에 자리가 있으면 ?add
                    cache.add(findCity);
                }
                answer += 5;
            }
        }
        System.out.println("final cache list = " + cache.toString());

        return answer;
    }
}
