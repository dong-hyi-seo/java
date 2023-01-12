package state_pattern.bad;

public class BadClient {
    public static void main(String[] args) {
        BadLaptop laptop = new BadLaptop();
        laptop.powerPush();
        laptop.setPowerState(BadLaptop.ON);
        laptop.powerPush();
        laptop.setPowerState(BadLaptop.SAVING);
        laptop.powerPush();
        laptop.setPowerState(BadLaptop.OFF);
        laptop.powerPush();
        laptop.setPowerState(BadLaptop.ON);
        laptop.powerPush();
    }
}
