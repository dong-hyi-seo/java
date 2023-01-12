package programmers.level2;

/**
 * @author donghyi.seo
 * @since 2022-12-19
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12951
 *  JadenCase 문자열 만들기
 *  문제 설명
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * s는 길이 1 이상 200 이하인 문자열입니다.
 * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
 * 숫자는 단어의 첫 문자로만 나옵니다.
 * 숫자로만 이루어진 단어는 없습니다.
 * 공백문자가 연속해서 나올 수 있습니다.
 * 입출력 예
 * s	return
 * "3people unFollowed me"	"3people Unfollowed Me"
 * "for the last week"	"For The Last Week"
 */
public class JadenCaseStringsSolution {


    public String mySolution(String s) {
        StringBuilder answer = new StringBuilder();

        //모두 소문자로 치환
        String lowerStr = s.toLowerCase();
        String[] strArr = lowerStr.split(" ");
        char end = s.charAt(s.length() - 1);

        for (int i=0; i<strArr.length; i++) {
            String str = strArr[i];
            System.out.println("str = " + str);
            if (!str.isEmpty()) {
                str = String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1, str.length());
            }
            answer.append(str);
            answer.append(" ");
        }
        if (end == ' ') {
            return answer.toString();
        }
        return answer.toString().trim();
    }

    public String anotherSolution(String s) {
        String[] wordArr = s.split(" ");
        char end = s.charAt(s.length() - 1);

        String result = "";
        for (int i = 0; i < wordArr.length; i++) {

            for (int j = 0; j < wordArr[i].length(); j++) {
                char alpha = wordArr[i].charAt(j);

                if (j == 0) {
                    alpha = Character.toUpperCase(alpha);
                } else {
                    alpha = Character.toLowerCase(alpha);
                }

                result += alpha;
            }
            result += " ";
        }

        //마지막에 공백문자가 들어가면 그대로 출력하고 아니면 앞뒤 공백을 제거한 후, 반환
        if (end == ' ') {
            return result;
        }

        return result.trim();
    }
}
