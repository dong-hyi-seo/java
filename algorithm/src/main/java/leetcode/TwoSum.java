package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author donghyi.seo
 * @since 2022-08-25
 * URL : https://leetcode.com/problems/two-sum/
 *
 * 정수 nums의 배열과 정수 대상이 주어지면 대상에 합산되도록 두 숫자의 인덱스를 반환합니다.
 * 각 입력에 정확히 하나의 솔루션이 있다고 가정하고 동일한 요소를 두 번 사용하지 않을 수 있습니다.
 * 어떤 순서로든 답변을 반환할 수 있습니다.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    /**
     * 내가 짠 소스코드는 이중 for문으로 찾아 O(N^2) 시간복잡도를 가진다.
     * 런타임 : 92ms
     * 메모리 사용량 : 42.1MB
     */
    public int[] mySolution(int[] nums, int target) {
        List<Integer> answerList = new LinkedList<>();

        //O(N^2) 시간복잡도를 가진다
        for (int i=0; i<nums.length; i++) {
            for (int a = i+1; a<nums.length; a++) {
                if (nums[i] + nums[a] == target) {
                    answerList.add(i);
                    answerList.add(a);
                    return answerList.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return null;
    }

    /**
     * 위 mySolution 이중for문을 한번만 돌게끔하여 해결해보자
     * target 9 값에서 nums 배열로부터 받은 숫자를 뺸 값이 이미 map에 담아놓은 것이 있으면!
     * 받은숫자의 index 와 map에 담아놓은거의 index를 배열에 담아 return 하면 된다.
     *
     * 런타임 : 3ms
     * 메모리 : 46.2 MB
     */
    public int[] anotherSolution (int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
