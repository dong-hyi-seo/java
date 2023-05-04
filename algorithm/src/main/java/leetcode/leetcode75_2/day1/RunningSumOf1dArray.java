package leetcode.leetcode75_2.day1;

/**
 * @since 2023-04-05
 * URL : https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1
 */
public class RunningSumOf1dArray {

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
