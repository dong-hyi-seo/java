package leetcode.leetcode75_2.day1;

/**
 * @since 2023-04-05
 * URL : https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
 * 배열이 주어집니다 nums. 배열의 누계를  runningSum[i] = sum(nums[0]…nums[i]).
 *
 * 의 누계를 반환합니다 nums.
 */
public class FindPivotIndex {

    public int[] solution(int[] nums) {

        int length = nums.length;
        int dpNum = 0;
        for (int i=0; i<length; i++) {
            dpNum = dpNum + nums[i];
            nums[i] = dpNum;
        }
        return nums;
    }
}
