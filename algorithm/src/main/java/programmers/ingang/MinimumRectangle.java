package programmers.ingang;

import java.util.Arrays;

/**
 * @author donghyi.seo
 * @since 2022-08-19
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 최소 직사각형 ( 완전탐색 )
 * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서,
 * 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
 * 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 *
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 *
 * 명함 번호	가로 길이	세로 길이
 * 1	60	50
 * 2	30	70 -> 70, 30
 * 3	60	30
 * 4	80	40
 * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
 * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다.
 * 이때의 지갑 크기는 4000(=80 x 50)입니다.
 *
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 */
public class MinimumRectangle {

    /**
     * 해당문제는 어렵게 생각 할 거 없이 주어지는 명함마다 큰수와 작은수를 분류해서,
     * 큰수는 큰수끼리 작은수는 작은수끼리 비교하여 가장 큰값을 각각 뽑은뒤에 곱해준다.
     */
    public int mySolution(int[][] sizes) {
        int answer = 0;

        int[] bigArr = new int[sizes.length];
        int[] smallArr = new int[sizes.length];

        for (int i=0; i<sizes.length; i++) {
            //명함의 가로길이
            int w = sizes[i][0];
            //명함의 세로길이
            int h = sizes[i][1];
            if (w > h) {
                bigArr[i] = w;
                smallArr[i] = h;
            } else {
                bigArr[i] = h;
                smallArr[i] = w;
            }
        }
        //stream 자체적으로 for문이 돌기 떄문에 한번의 loop으로 두개의 값을 구해보자
        answer = Arrays.stream(bigArr).max().getAsInt() * Arrays.stream(smallArr).max().getAsInt();
        return answer;
    }

    // for믄 돌때 한번에 두개의 값을 구하면 위에 mySolution보다 두배빠름
    public int anotherSolution(int[][] sizes) {
        int answer = 0;

        int max = 0;
        int min = 0;
        for (int[] size : sizes) {
            int paramMax = Math.max(size[0], size[1]);
            int paramMin = Math.min(size[0], size[1]);

            if (paramMax > max) {
                max = paramMax;
            }
            if (paramMin > min) {
                min = paramMin;
            }
        }
        answer = max * min;
        return answer;
    }

}
