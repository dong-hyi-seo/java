package programmers;

/**
 * 문자열 내 p와 y의 개수
 *
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 * 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
 *
 * 제한사항
 * 문자열 s의 길이 : 50 이하의 자연수
 * 문자열 s는 알파벳으로만 이루어져 있습니다.
 * 입출력 예
 * s	answer
 * "pPoooyY"	true
 * "Pyy"	false
 * https://school.programmers.co.kr/learn/courses/13577/lessons/96092
 */
public class 문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        boolean answer = mySolution("pPoooyY");
        System.out.println(answer);
    }

    public static boolean mySolution(String s) {
        boolean answer = false;

        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            if (c == 'p' || c == 'P') {
                pCnt++;
            }
            if (c == 'y' || c == 'Y') {
                yCnt++;
            }
        }
        if (pCnt == yCnt) {
            answer = true;
        }
        return answer;
    }
}
