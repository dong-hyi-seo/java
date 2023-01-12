package section2.item3;

import java.util.function.Supplier;

public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    //생성자를 private으로 만들고
    //해당 private 생성자는 자바 리플렉션으로 접근하기때문에 해당 생성자 호출시 runtime exception 에러 발생시키자
    private Elvis() {
        throw new RuntimeException("싱글턴 인스턴스를 리플렉션으로 생성할 수 없습니다.");
    }

    //정적 팩터리 메서드를 public static 멤버로 제공
    /**
     * API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다는점!
     * 원한다면 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다는 점 (item30)
     * 정적 팩터리의 메서드 참조를 공급자로(supplier)로 사용 할수 있다느점
     */
    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    //위 정적 팩터리의 메서드 참조를 공급자로 사용해보자
    public static Supplier<Elvis> getInstanceSupplier = Elvis::getInstance;


}
