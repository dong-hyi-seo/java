package section7.item43;

import java.util.HashMap;
import java.util.Map;

/**
 * 람다보다는 메서드 참조를 사용하라
 * 해당부분에서 강조하는것은
 * 람다가 없으면 메소드참조도 안된다.
 *
 */
public class Item43 {

    private static Map<String, Integer> MAP = new HashMap<>() {{
        put("TEST",1);
        put("TEST1",2);
        put("TEST2",3);
    }};

    //아래와 같이 생성하면 불변이기때문에 수정 못함
    /*private static Map<String, Integer> MAP = Map.of(
            "TEST" , 1,
            "TEST1", 2,
            "TEST2", 3
    );*/
    public static void main(String[] args) {
        badCase();
        goodCase();
    }

    /**
     * map key에 대한 값에 대하여 두번째 인자 1값을 더한다
     * 깔끔해 보이는 코드지만 아직도 거추장 스러운 부분이 남아있다.
     * 매개변수 count, incr 값이 크게 하는일 없이 공간을 꾀 차지함.
     * Integer class의 sum 정적메소드 사용
     * 즉, 람다대신 이 메서드의 참조를 전달하면 똑같은 결고를  더 보기좋게 수정이 가능함
     */
    static void badCase() {
        String key = "TEST";
        //map key에 대한 값에 대하여 두번째 인자 1값을 더한다
        MAP.merge(key, 1, (count, incr) -> count + incr);
        System.out.println("badCase MAP = " + MAP);
    }

    static void goodCase() {
        String key = "TEST1";
        MAP.merge(key, 10, Integer::sum);
        System.out.println("goodCase MAP = " + MAP);
    }
}
