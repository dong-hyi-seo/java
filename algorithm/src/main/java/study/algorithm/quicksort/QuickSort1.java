package study.algorithm.quicksort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author donghyi.seo
 * @since 2023-01-10
 * https://www.notion.so/QuickSort-0921f5c3fd8d4992bd63aad4a76920b8
 */
public class QuickSort1 {

    public static void main(String[] args) {
        List<Integer> list = List.of(6, 5, 1, 4, 7, 2, 3);

        List<Integer> sortList = quickSort(list);
        System.out.println("sortList = " + sortList);
    }

    public static List<Integer> quickSort(List<Integer> list) {
        //list의 사이즈가 1보다 같거나 작을경우 정렬할필요 없다!
        if (list.size() <= 1) return list;

        //pivot 중간 값위치를 선정한다.
        int pivot = list.get(list.size() / 2);

        List<Integer> lessList = new ArrayList<>();
        List<Integer> equalList = new ArrayList<>();
        List<Integer> greaterList = new LinkedList<>();

        for (int num : list) {
            //위에서 선정한 pivot보다 작은값을 add
            if (num < pivot) lessList.add(num);
            //위에서 선정한 Pivot보다 큰값을 add
            else if (num > pivot) greaterList.add(num);
            else equalList.add(num);
        }
        return Stream.of(quickSort(lessList), equalList, quickSort(greaterList))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
