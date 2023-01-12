package study.algorithm;

import java.util.List;

/**
 * @author donghyi.seo
 * @since 2023-01-10
 *
 * 퀵 정렬 스터디 클래스
 * QuickSolution1 은 재귀로 정렬했지만
 * 재귀함수 호출시 새로운 리스트를 생서하여 리턴하기ㄷ떄문에 메모리사용측면에서 비효율적
 * 해당 알고리즘은 in-place알고리즘으로 최적화 해본다.
 */
public class QuickSortInPlace {
    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 4, 7, 2, 3};

        sort(arr, 0, arr.length-1);
        System.out.println("result arr = " + arr);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;


    }

}
