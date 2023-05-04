package leetcode.leetcode75_2.day1;

/**
 * @since 2023-04-05
 * URL : https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
 * 정수 배열이 주어지면 이 배열의 피벗 인덱스를nums 계산합니다 .
 *
 * 피벗 인덱스는 인덱스 왼쪽에 있는 모든 숫자의 합이 인덱스 오른쪽에 있는 모든 숫자의 합계와 같은 인덱스 입니다 .
 *
 * 인덱스가 배열의 왼쪽 가장자리에 있으면 왼쪽 0에 요소가 없기 때문에 왼쪽 합이 됩니다. 이는 배열의 오른쪽 가장자리에도 적용됩니다.
 *
 * 가장 왼쪽 피벗 인덱스를 반환 합니다 . 해당 색인이 없으면 를 반환합니다 -1.
 */
public class FindPivotIndex {

    public int solution(int[] nums) {
        int answer = -1;

        //왼쪽부터 하나씩 나아가면서 오른쪽 sum값들과 같은지 확인
        int leftSum = 0;
        int rightSum = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (i > 0) {
                leftSum = leftSum + nums[i - 1];
            }
            rightSum = 0;
            for (int y=i+1; y<length; y++) {
                rightSum += nums[y];
            }
            if (leftSum == rightSum) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
