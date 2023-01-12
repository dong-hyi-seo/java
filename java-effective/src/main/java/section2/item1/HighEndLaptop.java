package section2.item1;

public class HighEndLaptop implements Laptop {
    @Override
    public void turnOn() {
        System.out.println("전원 버튼을 누르자마자 부팅이 완료된다.");
    }
}
