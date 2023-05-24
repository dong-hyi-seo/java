package programmers.complete_search;

/**
 * 카펫 - Level2
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet {

    /**
     * 최소 사각형의 가로 세로길이는 3,3 이다. 그래서 3,3부터 찾아나가면 될듯
     * brown : 8, yellow : 1
     * 총 네모 수는 brown + yellow = 9
     * 가운데 사각형의 가로와 세로는 테두리 가로 세로의 -2;
     * 가운데(노란색영역)의 가로 * 세로 값은 결국 yellow 사각형 개수
     *
     * 총 네모수의 약수를 구하면 가로세로 사이즈의 후보가 나온다.
     * 가로 세로 모두 3이상이여야기때문에 3인거들은 제외시킨다.
     * 그리고 노란색 가로는 갈색 가로의 -2 세로도 마찬가지로 -2이기때문에 이 공식에 부합되는 것만 찾으면됨
     *
     * 이문제는 총 네모수의 약수범위내에서 조건에 부합하는 후보를 찾는것이 중요하다
     */
    public int[] solution(int brown, int yellow) { //10 , 2
        int[] answer = new int[2];

        int sum = brown + yellow;

        //12 약수 (나눈값, 그리고 몫)
        //일단 모든 격자의 수에 대하여 약수를 구해본다.
        for (int i=3; i < sum; i++) {
            int j = sum / i;
            if (sum % i == 0 && j >= 3) {
                //가로가 세로보다 크거나 같다고했으니?
                int width = Math.max(i, j);
                int height = Math.min(i, j);
                int center = (width - 2) * (height - 2); //예상되는 총 가로 세로 -2씩 한것을 곱한것이
                if (center == yellow && brown == sum - yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }

}
