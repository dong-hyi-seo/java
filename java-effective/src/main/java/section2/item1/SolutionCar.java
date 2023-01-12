package section2.item1;

public class SolutionCar {

    //인스턴스 재활용
    private static final SolutionCar INSTANCE = new SolutionCar("Maverick");

    private String name;
    private String price;
    private short year;

    /**
     * 출시가 안된 name만 존재하는 car 객체 생성
     */
    private SolutionCar(String name) {
        this.name = name;
    }

    public void set() {

    }

    public static SolutionCar createNotReleaseCar(String name) {
        return new SolutionCar(name);
    }

    public static SolutionCar getDefaultInstance() {
        return INSTANCE;
    }
}
