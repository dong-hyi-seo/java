package section3.item14;

import java.util.Comparator;

public class Apple implements Comparable<Apple> {

    private int weight;
    private String color;
    private String variety;

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getVariety() {
        return variety;
    }

    /**
     * this < other : -1 을 반환한다.
     * this == other : 0 을 반환한다.
     * this > other : 1 을 반환한다.
     * -> Apple 클래스에서 weight 가 핵심이여서 먼저 정렬 -> 만약 무게가 같으면 -> 두번쨰로 중요한 Color 필드를 비교 -> 색깔도 같다면 - > variety 필드 비교
     */
    @Override
    public int compareTo(Apple o) {
        int result = Integer.compare(o.weight, weight);
        if (result == 0) { //무게가 같으면 ?
            result = color.compareTo(o.color);
        }
        if (result == 0) {
            result = variety.compareTo(o.variety);
        }
        return result;
    }

    /**
     * 다른 방식
     * 자바 8이상부터는 Compartor 인터페이스가 일련의 비교자 생성 메서드와 팀을 꾸려 메서드 연쇄
     * 방색으로 비교자를 생성 할 수 있다.
     * -> 약간의 성능 저하가 있음...
     */
    public int compareToAnotherVersion(Apple o) {
        Comparator<Apple> comparator = Comparator.comparingInt(Apple::getWeight)
                .thenComparing(Apple::getColor)
                .thenComparing(Apple::getVariety);
        return comparator.compare(this,o);
    }

}
