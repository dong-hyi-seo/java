package section6.item34;

public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6);

    //각 속성을 private final로 선언
    private final double mass;          // 질량
    private final double raduis;        // 반지름
    private final double surfaceGravity; // 표면중력

    private static final double G = 6.67300E-11;


    Planet(double mass, double raduis) {
        this.mass = mass;
        this.raduis = raduis;
        this.surfaceGravity = G * mass / (raduis * raduis);
    }

    //아래의 public method로 접근하게한다.
    public double mass() {
        return mass;
    }

    public double radius() {
        return raduis;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }

}
