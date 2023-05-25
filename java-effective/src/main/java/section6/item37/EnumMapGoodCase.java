package section6.item37;

import java.util.*;

/**
 * 1. 이전 ordinal을 사용한 코드와 다르게 안전하지 않은 형변환을 사용하지 않는다.
 * 2. 결과를 출력하기 위해 번거롭던 과정도 EnumMap 자체가 toString을 제공하기 때문에 번거롭지 않게되었다.
 * 3. ordinal을 이용한 배열 인덱스를 사용하지 않으니 인덱스를 계산하는 과정에서 오류가 날 가능성이 존재하지 않는다.
 * 4. EnumMap은 그 내부에서 배열을 사용하기 때문에 내부 구현 방식을 안으로 숨겨서 Map의 타입 안정성과 배열의 성능을 모두 얻어냈다.
 */
public class EnumMapGoodCase {

    public static void main(String[] args) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle,new HashSet<>());
        }
        System.out.println("plantsByLifeCycle = " + plantsByLifeCycle);

        List<Plant> garden = List.of(
                new Plant("test1", Plant.LifeCycle.ANNUAL),
                new Plant("test2", Plant.LifeCycle.PERENNIAL),
                new Plant("test3", Plant.LifeCycle.BIENNIAL)
        );
        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }
        //EnumMap은 toString을 재정의하였다.
        System.out.println(plantsByLifeCycle);
    }
}
