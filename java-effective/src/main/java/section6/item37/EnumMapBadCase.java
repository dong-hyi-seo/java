package section6.item37;

import java.util.*;

/**
 * 동작은 하지만 문제가 많다.
 * 배열은 제네릭과 호환되지 않으니 비검사 형변환을 수행해야 하고 깔끔히 컴파일되지 않을 것이다.
 * 배열은 각 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야 한다.
 * 정확한 정숫값을 사용한다는 것을 우리가 직접 보증해야 한다는 것이 가장 큰 문제다. 정수는 열거 타입과 달리 타입 안전하지 않기 때문이다.
 * 잘못된 값을 사용하면 잘못된 동작을 묵묵히 수행하거나, 운이 좋다면 ArrayIndexOutOfBoundsException을 던질 것이다.
 *
 *
 * 제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미
 * 필요에 의해 지정할 수 있도록 하는 일반(Generic) 타입
 */
public class EnumMapBadCase {

    public static void main(String[] args) {
        //Set 배열을 생성해 생애주기별로 관리한다. 총 3개의 배열이 만들어질 것이다. 각 배열을 순회하여 빈 HashSet으로 초기화 해준다.
        //배열은 제네릭과 호환되지 않는다. 따라서 비검사 형변환을 수행하여야한다.
        Set<Plant>[] plantByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i=0; i< plantByLifeCycle.length; i++) {
            plantByLifeCycle[i] = new HashSet<>();
        }
        System.out.println("plantByLifeCycle 0= " + Arrays.toString(plantByLifeCycle));

        List<Plant> garden = List.of(
                new Plant("test1", Plant.LifeCycle.ANNUAL),
                new Plant("test2", Plant.LifeCycle.PERENNIAL),
                new Plant("test3", Plant.LifeCycle.BIENNIAL)
        );
        for (Plant plant : garden) {
            //plant 들을 배열의 Set에 추가한다. 이때 plant가 가지고있는 LifeCycle 열거타입의 ordinal 값으로 배열의 인덱스를 결정한다. 그 결과 식물의 생애주기 별로 Set에 추가된다.
            plantByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        System.out.println("plantByLifeCycle 1= " + Arrays.toString(plantByLifeCycle));
        // 결과 출력
        // 결과를 출력한다. 열거 타입의 values로 반환되는 열거 타입 상수 배열의 순서는 ordinal 값으로 결정되기 때문에 Set 배열의 각 Set이 의미하는 생애주기는 values의 순서와 같을것이다.
        for (int i = 0; i < plantByLifeCycle.length; i++) {
            System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantByLifeCycle[i]);
        }
    }
}
