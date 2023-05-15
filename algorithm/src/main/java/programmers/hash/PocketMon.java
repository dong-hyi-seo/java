package programmers.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 포켓몬
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class PocketMon {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int size = nums.length;
        if (size == 0) { //포멧몬이 0마리일때는 ?
            return 0;
        }

        int max = size/2;
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
            if (set.size() >= max) {
                break;
            }
        }
        return set.size();
    }
}
