package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author donghyi.seo
 * @since 2023-01-10
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 가장큰수
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
 * 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	"6210"
 * [3, 30, 34, 5, 9]	"9534330"
 */
public class BigNumberSolution {
    /**
     * 원소가 첫째자리가 제일큰수대로 재정렬해서 붙인다?
     */
    public String mySolution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> numberStrList = new ArrayList<>();
        System.out.println("numbers = " + Arrays.toString(numbers));
        for (int i=0; i<numbers.length; i++) {
            numberStrList.add(Integer.toString(numbers[i]));
        }
        List<String> sortResultList = quickSort(numberStrList);
        if (sortResultList.get(sortResultList.size()-1).equals("0")) {
            return "0";
        }
        for (int i = sortResultList.size() - 1 ; i >= 0; i--) {
            answer.append(sortResultList.get(i));
        }
        System.out.println("answer = " + answer.toString());
        return answer.toString();
    }
    //9534330
    public List<String> quickSort(List<String> numberStrList) {
        if (numberStrList.size() <= 1) return numberStrList;

        //pivot 중간 값위치를 선정한다.
        String pivotStr = numberStrList.get(numberStrList.size() / 2);

        List<String> lessList = new ArrayList<>();
        List<String> equalList = new ArrayList<>();
        List<String> greaterList = new LinkedList<>();


        // 그냥 두개의수를 합쳐서 더 큰수로 정렬하면될것?
        for (String numStr : numberStrList) {
            int a = Integer.parseInt(numStr + pivotStr);
            int b = Integer.parseInt(pivotStr + numStr);

            //위에서 선정한 pivot보다 작은값을 add
            if (a < b) lessList.add(numStr);
                //위에서 선정한 Pivot보다 큰값을 add
            else if (a > b) greaterList.add(numStr);
            else equalList.add(numStr);
        }
        return Stream.of(quickSort(lessList), equalList, quickSort(greaterList))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * mySolution 보다 두배더빠름
     */
    public String anotherSolution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort((a, b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }

}
