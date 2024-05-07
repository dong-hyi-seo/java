package programmers.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



/**
 * Java 에서 제공하는 list의 sort 기능 활용할 수 있는데
 * 왜? 종류별로 알고리즘을 학슴해야하나 ?
 *
 * 1. 다양한 알고리즘을 학습하면서 : 문제풀이의 접근 방식을 학습할 수 있다.
 * 2. 문제를 해결하는 알고리즘은 한가지가 아니구나!
 */
public class ComparatorStudy {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(r.nextInt(50));
        }
        //오름차순 정렬
        list.sort(Comparator.naturalOrder());
        System.out.println("asc = " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("desc = " + list);

        List<MyData> myList = new LinkedList<>();
        Random r2 = new Random();
        for (int i = 0; i < 20; i++) {
            myList.add(new MyData(r.nextInt(50)));
        }

        //오름차순 정렬
        myList.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });
        System.out.println("myList asc = " + myList);

        //내림차순
        myList.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o2.v - o1.v;
            }
        });
        System.out.println("myList desc = " + myList);

        //다른방법의 오름차순
        myList.sort(Comparator.naturalOrder());
        System.out.println("myList asc 1 = " + myList);

        //다른방법의 내림차순
        myList.sort(Comparator.reverseOrder());
        System.out.println("myList desc 1 = " + myList);

        //quick sort
        myList = quickSort(myList);
        System.out.println("quick sort myList = " + myList);
    }

    /**
     * quick sort
     */
    static List<MyData> quickSort(List<MyData> list) {
        if (list.size() <= 1) return list;

        //pivot 선정 (맨앞에것을 꺼내보자)
        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>(); //pivot보다 작은애들
        List<MyData> greater = new LinkedList<>(); //pivot보다 큰애들

        for (MyData m : list) {
            if (pivot.compareTo(m) > 0) {
                lesser.add(m);
            } else {
                greater.add(m);
            }
        }

        List<MyData> merged = new LinkedList<>(quickSort(lesser));
        merged.add(pivot);
        merged.addAll(quickSort(greater));
        return merged;
    }


}
class MyData implements Comparable<MyData> {

    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "v=" + v +
                '}';
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v, o.v);
    }
}