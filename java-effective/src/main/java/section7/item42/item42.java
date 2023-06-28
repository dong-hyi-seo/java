package section7.item42;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class item42 {

    private static List<String> words = Stream.of("A","B","CD","EFG").collect(Collectors.toList());

    // 이렇게 생성하면 불변한 객체로 생성되기때문에 Collections.sort 사용 못함.
    //private static List<String> words = Stream.of("A","B","CD","EFG").toList();
    public static void main(String[] args) {
        badCase();
        goodCase();
    }

    public static void badCase() {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(), t1.length());
            }
        });
        System.out.println("words = " + words);
    }

    public static void goodCase() {
        //1
        Collections.sort(words , (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        //2
        Collections.sort(words, Comparator.comparingInt(String::length).reversed());
        System.out.println("words = " + words);
    }


}
