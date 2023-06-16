package programmers.dfs_bfs;

/**
 * 타겟넘버
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {

    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    static int DFS(int[] numbers, int target, int depth, int sum) {
        int matchCount = 0;
        if (depth == numbers.length) { //모두 사용했을경우 ?
            if (target == sum) { //전달받은 결과값과 재귀로 돌린 sum값이 같을경우 count + 1 해준다.
                return 1;
            }
            return 0;
        }

        //더하기와 빼기를 조합하는 것이므로 재귀안에서 +에 대한 재귀, -에 대한 제귀를 해준다.
        matchCount += DFS(numbers, target, depth+1, sum + numbers[depth]);
        matchCount += DFS(numbers, target, depth+1, sum - numbers[depth]);
        return matchCount;
    }
}
