package section2.item1;

public class Item1Test {

    public static void main(String[] args) {

        /**
         * Before
         * 출시가 아직 안되었으며 name만 가지고있는 차 객체 생성
         * 당 method name 가지고 구분이 잘안됨
         */
        Car notReleased = new Car("Maverick");

        /**
         * solution1
         * 1. 이름을 가질 수 있다.
         * method name만으로 어떤 객체를 생성하는지 알수 있음!
         * 두개의 객체를 생성하여 비교해보면 false가 나옴.
         */
        SolutionCar notReleasedSolution1 = SolutionCar.createNotReleaseCar("Maverick");
        SolutionCar notReleasedSolution2 = SolutionCar.createNotReleaseCar("Maverick");

        System.out.println("solution1 same 1 = "
                + notReleasedSolution1.equals(notReleasedSolution2)); //-> false
        System.out.println("solution1 same 2 = "
                + (notReleasedSolution1 == notReleasedSolution2)); //-> false

        /**
         * solution2
         * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다
         * SolutionCar 내부에 singleton으로 생성되어있어 동일한 instance를 사용!
         * 그러므로 비교해보면 true
         * 인스턴스를 미리 만들어 놓거나 인스턴스 캐싱으로 재사용하여 불필요한 객체 생성을 피할 수 있다.
         */
        SolutionCar notReleaseInstance1 = SolutionCar.getDefaultInstance(); // -> true
        SolutionCar notReleaseInstance2 = SolutionCar.getDefaultInstance();
        System.out.println("solution2 same 1 = "
                + notReleaseInstance1.equals(notReleaseInstance2)); // -> true
        System.out.println("solution2 same 2 = "
                + (notReleaseInstance1 == notReleaseInstance2)); // -> true

        /**
         * solution3
         * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
         */
        Laptop lowLapTop = Laptop.lowQualityLaptop();
        lowLapTop.turnOn();

        /**
         * solution4
         * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환
         */
        try {
            Laptop findLapTopByName1 = Laptop.getLaptop("low");
            findLapTopByName1.turnOn();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("solution4 error : " + e.getMessage());
        }

        /**
         * solution5
         * 5. 정적 팩토리 메서드를 작성하는 시점에는 반환 할 객체의 클래스가 존재하지 않아도 된다.
         */
        try {
            Laptop findLapTopByName2 = Laptop.getLaptop("high");
            findLapTopByName2.turnOn();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("solution5 error : " + e.getMessage());
        }
    }
}
