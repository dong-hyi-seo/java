package section6.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다음과 같이 apply 추상 메서드를 선언하고, 각 상수에 맞게 재정의 하는 방법이다. 이렇게 구현하면,
 * 새로운 상수 추가시에도 apply 재정의 사시를 까먹기 어려울 것이며,
 * 추상메서드를 재정의하지 않은 경우 컴파일 오류로 알려준다.
 */
public enum OperationGoodCase {

    PLUS("+")    {public double apply(double x, double y){return x + y;}},
    MINUS("-")   {public double apply(double x, double y){return x - y;}},
    TIMES("*")   {public double apply(double x, double y){return x * y;}},
    DIVIDE("/")  {public double apply(double x, double y){return x / y;}};

    private final String symbol;

    OperationGoodCase(String symbol) {
        this.symbol = symbol;
    }

    //열거 타입의 toString 메서드를 재정의 했다면,
    // toString이 반환하는 문자열을 해당 열거 타입 상수로 변환해주는
    // fromString 메서드도 함께 제공하는걸 고려
    @Override public String toString() {
        return symbol;
    }
    public abstract double apply(double x, double y);

    // 열거 타입 상수 생성 후 정적 필드가 초기화될 때 추가됨.
    private static final Map<String, OperationGoodCase> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e->e));

    public static Optional<OperationGoodCase> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol)); // 주어진 연산이 가리키는 상수가 존재하지 않을 수 있음
    }
}
