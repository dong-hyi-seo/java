package programmers.ingang;

import java.util.*;

/**
 * HashSet
 * 1. 중복된 값을 허용하지 않는다.
 * 2. 순서를 보장하지 않음
 * LinkedHashSet
 * 1. 중복된 값을 허용하지 않음
 * 2. 순서를 보장한다!!
 */
public class SetTraining {

    /**
     *  로또복권의 번호는 1에서 45 사이의 값을 가진 6개의 숫자로 구성됩니다.
     * 로또복권을 신청하는 사용자들은 OMR카드에 숫자를 마킹하여 신청을 하는데, 가끔 잘못 표시하여 신청하는 사용자들이 있습니다.
     * 로또복권에 등록 가능한 숫자조합인지 확인하는 기능을 작성해 주세요
     *
     * 입력1: [4, 7, 32, 43, 22, 19]
     * 출력1: true
     *
     * 6개의 숫자가 중복없이 1~45사이의 값을 가지고 로또복권 등록이 가능합니다.
     *
     * 입력2: [3, 19, 34, 39, 39, 20]
     * 출력2: false
     *
     * 6개의 숫자 중 39가 중복되어 로또복권 등록이 불가능합니다.
     */
    public boolean lottoMySolution(int[] lotto) {
        // 로또 배열 수는 6개와 같아야한다.
        System.out.println("input lotto arr length : " + lotto.length);
        if (lotto.length != 6) {
            return false;
        }

        //로또 숫자는 1~45 사이 중복이 없어야한다.
        HashSet<Integer> lottoSet = new HashSet<>();
        for (int num : lotto) {
            if (num >= 1 && num <= 45) {
                System.out.println(num);
                lottoSet.add(num);
            }
        }
        System.out.println("lottoSet = " + lottoSet);
        if (lottoSet.size() != 6) {
            return false;
        }
        return true;
    }

    public boolean endToEndMySolution(String[] words) {
        boolean answer = true;

        //입력받은 단어의 사이즈
        int wordArrLength = words.length;

        //Set interface 만들어서 중복을 제거하자
        //단 구현은 LinkedHashSet으로 받자 중복을제거하되 순서를 보장해야한다.
        //끝말잇기라서!
        Set<String> wordSet = new LinkedHashSet<>(Arrays.asList(words));

        //원래 입력받은 단어들의 수와 중복제거한 단어들의 수 비교하여
        //일치하지 않으면 실패!
        if (wordArrLength != wordSet.size()) {
            return false;
        }

        //list로 변환
        ArrayList<String> wordList = new ArrayList<>(wordSet);

        for (int i=0; i<wordList.size(); i++) {
            if (i == wordList.size() - 1) {
                break;
            }
            String currentWord = wordList.get(i);
            int currentWordLength = currentWord.length();
            String currentWordEnd = currentWord.split("")[currentWordLength-1];

            System.out.println("currentWord :" + currentWord + " // end : " + currentWordEnd);

            String nextWord = wordList.get(i+1);
            int nextWordLength = nextWord.length();
            String nextWordFirst = nextWord.split("")[0];


            //current word 끝자리 문자와
            //next word 첫자리 문자가 일치하는지 체크
            if (!currentWordEnd.equals(nextWordFirst)) {
                return false;
            }
        }
        return answer;
    }

    /**
     * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
     *
     * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
     * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
     * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 배열 arr의 크기 : 1,000,000 이하의 자연수
     * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
     */
    public int[] notLikeSameNumSolution(int[] arr) {

        //해당 문제는 중복제거가 연속된 숫자만 제거하는 것이기 때문에 set을 쓰면 안된다.
        List<Integer> list = new ArrayList<>();
        int saveNum = -1;
        for (int i=0; i<arr.length; i++) {
            if (saveNum != arr[i]) {
                saveNum = arr[i];
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
