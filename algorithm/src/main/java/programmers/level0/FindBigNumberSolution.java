package programmers.level0;

public class FindBigNumberSolution {

    public int[] solution(int[] array) {
        int[] answer = new int[2];

        int maxNumber = 0;
        int maxIndex = 0;
        for (int i=0; i<array.length; i++) {
            if (maxNumber < array[i]) {
                maxNumber = array[i];
                maxIndex = i;
            }
        }
        answer[0] = maxNumber;
        answer[1] = maxIndex;
        return answer;
    }
}
