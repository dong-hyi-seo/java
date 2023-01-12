package section3.item11;

import java.util.HashMap;

/**
 * item11. equals를 재정의하려거든 hashCode도 재정의 해라
 * @author donghyi.seo
 * @since 2022-09-07
 */
public class HashCodeTest {

    public static void main(String[] args) {

        /**
         * hashcode 재정의 한경우
         */
        HashMap<ExtendedPhoneNumber, String> extendedMap = new HashMap<>();
        extendedMap.put(new ExtendedPhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        System.out.println("is same ? = " + (extendedMap.get(new ExtendedPhoneNumber(707, 867, 5307)).equals("제니")));

        /**
         * equals만 재정의하고 hashcode 재정의 안했을 경우!
         */
        HashMap<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());

        //hashcode가 재정의되어 있지 않기 때문에 null값이 나옴
        System.out.println("is same ? = " + (map.get(new PhoneNumber(707, 867, 5307)).equals("제니")));

    }
}
