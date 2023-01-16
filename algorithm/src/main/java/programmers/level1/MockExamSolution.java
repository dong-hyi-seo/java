package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author donghyi,seo
 * @since 2023-01-12
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 모의고사 문제
 *
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 2, 4, 4, 5, 2, 5, ...
 *  * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class MockExamSolution {

    private final static int[] people1 = {1, 2, 3, 4, 5};
    private final static int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private final static int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    /**
     * 각 수포자의 답 찍는 패턴을 찾는다 그래서 답안지 배열 index와 맞게일치하는 것을 가지고오면딘다.
     * 일치하는 것의 판단은 규치패턴수의 대한 나머지!
     * @param answers
     * @return
     */
    public int[] mySolution(int[] answers) {
        List<Integer> list = new ArrayList<>();

        //1번 수포자는 5개씩
        //2번 수포자는 8개씩
        //3번 수포자는 10개씩

        //답안지를 가지고 순서대로 체크
        int[] countArr = new int[3];
        int peopleIndex = 0;
        int people1Num = 0;
        int people2Num = 0;
        int people3Num = 0;
        for ( int i=0; i<answers.length; i++) {
            // i == 0 / index 0
            // i == 1 / index 1
            // i == 2 / index 2
            // i == 3 / index 3
            // i == 4 / index 4
            // i = 5 / index 0
            // i == 6 / index 1
            // i == 7 / index 2
            int num = answers[i];
            if (i < 5) {
                peopleIndex = i;
            } else {
                peopleIndex = i % 5;
            }
            if (num == people1[peopleIndex]) {
                people1Num ++;
            }

            if (i < 8) {
                peopleIndex = i;
            } else {
                peopleIndex = i % 8;
            }
            if (num == people2[peopleIndex]) {
                people2Num ++;
            }

            if (i < 10) {
                peopleIndex = i;
            } else {
                peopleIndex = i % 10;
            }
            if (num == people3[peopleIndex]) {
                people3Num ++;
            }
        }
        countArr[0] = people1Num;
        countArr[1] = people2Num;
        countArr[2] = people3Num;

        int max = Arrays.stream(countArr).max().getAsInt();
        for (int i=0; i<countArr.length; i ++) {
            if (max == countArr[i]) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
