package programmers.hash;

import java.util.Arrays;

/**
 * 완주하지못한선수 - Level1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class NotCompletedPlayer {

    public String solution(String[] participant, String[] completion) {

        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) { //완주못한애
                answer = participant[i];
                break;

            }
        }
        if (answer == "") {
            answer = participant[participant.length - 1];
        }
        return answer;
    }
}
