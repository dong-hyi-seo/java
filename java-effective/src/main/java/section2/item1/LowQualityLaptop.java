package section2.item1;

public class LowQualityLaptop implements Laptop {
    @Override
    public void turnOn() {
        System.out.println("지지직... 느리게 켜진다.");
    }
}
