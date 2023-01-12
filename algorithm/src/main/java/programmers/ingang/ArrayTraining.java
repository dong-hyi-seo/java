package programmers.ingang;

import java.util.Arrays;

public class ArrayTraining {

    public int[] kSolution(int[] array, int[][] commands) {
        //command = i 번째부터 j까지 자르고 정렬후 k 번쨰 숫자뽑기
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int select = commands[i][2]-1;
            int[] tempArr = Arrays.copyOfRange(array, from, to);
            Arrays.sort(tempArr);
            answer[i] = tempArr[select];
        }

        return answer;
    }
}
