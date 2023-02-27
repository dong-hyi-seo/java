package leetcode.leetcode75.day2;

/**
 * @since 2023.02.27
 * URL : https://leetcode.com/problems/longest-common-prefix/?envType=study-plan&id=level-2
 * 가장 긴 공통 접두사
 * 문자열 배열 중에서 가장 긴 공통 접두사 문자열을 찾는 함수를 작성하십시오.
 * 공통 접두사가 없으면 빈 문자열을 반환합니다 "".
 * 즉 모든 문자열에 공통되는 가장 긴 접두사를 찾으라는것
 * 주어진 단어모두 공통된 접두사가 있을때 공통접두사 return
 *
 * 예1)
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * 예2)
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * 제한사항)
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters. (영문 소문자로만 구성이되어있음)
 */
public class LongestCommonPrefix {

    /**
     *
     */
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        if (strs == null || strs.length == 0) return answer;

        answer = strs[0]; //a
        for (int i=1; i<strs.length; i++) {
            String curStr = strs[i]; //b
            //0번째 단어를 점점 끝에서 자르면서 체크해나간다.
            System.out.println("curstr = " + curStr + " ==============");
            while (curStr.indexOf(answer) != 0) {
                System.out.println("curStr.indexOf(answer)  = " + curStr.indexOf(answer) + " //answer : " + answer);
                answer = answer.substring(0, answer.length()-1);
            }
        }
        return answer;
    }
}
