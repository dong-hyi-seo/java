package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @since 2023-02-21
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 정확히 한 번 나타나는 한 요소를 제외하고 모든 요소가 정확히
 * 두 번 나타나는 정수로만 구성된 정렬된 배열이 제공됩니다.
 * 한 번만 나타나는 단일 요소를 반환합니다.
 * 솔루션은 O(log n)시간과 O(1)공간에서 실행되어야 합니다.
 *
 * 예
 * 입력: 숫자 = [1,1,2,3,3,4,4,8,8]
 * 출력: 2
 *
 * 입력: 숫자 = [3,3,7,7,10,11,11]
 * 출력: 10
 *
 * 제약:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class SingleElementInaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        //두개씩 체크
        int answer = -1;
        for (int i=0; i<nums.length; i+=2) {
            int first = nums[i];
            if (i == nums.length - 1){
                answer = first;
                break;
            }

            int second = nums[i+1];
            if (first != second) {
                answer = first;
                break;
            }
        }
        return answer;
    }
}
