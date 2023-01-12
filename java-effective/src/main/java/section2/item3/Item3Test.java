package section2.item3;

/**
 * item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라
 */
public class Item3Test {
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
