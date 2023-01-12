package section4.item16;

import section4.item16.bad.CustomHashSet;
import section4.item16.good.CustomHashSetV2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Item16Test {

    public static void main(String[] args) {
        /**
         * bad test
         * 오류의 가능성이 있는 상속 class 테스트 (기댓값은 3)
         * 하지만 6이나온다..
         */
        CustomHashSet<String> customHashSet = new CustomHashSet<>();
        List<String> test = Arrays.asList("아","이","스");
        customHashSet.addAll(test);

        System.out.println("bad result : " + customHashSet.getAddCount());

        /**
         * 위 bad test 해결
         */
        CustomHashSetV2<String> customHashSetV2 = new CustomHashSetV2<>(new HashSet<>());
        List<String> testV2 = Arrays.asList("아","이","스");
        customHashSetV2.addAll(testV2);
        System.out.println("good result : " + customHashSetV2.getAddCount());
    }
}
