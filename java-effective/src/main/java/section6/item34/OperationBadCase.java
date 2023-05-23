package section6.item34;

/**
 * enum을 통한 연산처리 나쁜 예
 * 다음과 같이 사칙연산 계산기의 연산종류를 열거 타입으로 선언하고,
 * 상수가 뜻하는 연산을 하는 apply() 메서드가 있다.
 * 위 코드는 동작은 하지만, 좋은 방법은 아니다.
 * 새로운 상수를 추가하면 해당 case문도 추가해야하고,
 * 혹시라도 깜빡한 경우 컴파일은 되지만 AssertionError 오류가 발생된다.
 */
public enum OperationBadCase {

    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }
}
