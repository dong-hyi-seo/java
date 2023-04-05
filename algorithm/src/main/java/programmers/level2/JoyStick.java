package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @since 2023-04-05
 * TODO : https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java
 문제 설명
 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

 조이스틱을 각 방향으로 움직이면 아래와 같습니다.

 ▲ - 다음 알파벳
 ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

 - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

 제한 사항
 name은 알파벳 대문자로만 이루어져 있습니다.
 name의 길이는 1 이상 20 이하입니다.
 입출력 예
 name	return
 "JEROEN"	56
 "JAN"	23
 */
public class JoyStick {

    //AAAAAA
    //JEROEN
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; //다음 값을 확인
        int move = length - 1; //좌우 움직임수

        for (int i=0; i<length; i++) {
            //알파벳 이동
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            //순서대로 가는것과, 뒤로 돌아가는 것중 이동수가 적은 것을 선택
            // i*2를 하는이유는 백할려면 일단 내가 온만큼 다시 돌아간다음 + (내가 현재있는 위치를 전체길이에서 뺀만큼 돌아가야한다)
            move = Math.min(move, i * 2 + length - index);


            //BBBBAAAAAAAB와 같이 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우도 고려
            move = Math.min(move, (length - index) * 2 + i);

        }
        return answer + move;
    }

}
