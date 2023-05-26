package section6.item38;

/**
 * item38. 확장 할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라
 * 열거타입을 확장하는 건 조지 않은생각
 *
 * 확장할 수 있는 열거타입이 어울리는 쓰임이 최ㅗ한 하나는 있다. 바로 연산코드다.
 * 연산코드의 각 원소는 특정기계가 수행하는 연산을 뜻한다. 기본 아이디어는 열거타입이 임의의 인터페이스를 구현할수 있다는 사실을 이용하는것
 */
public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) { return x / y; }
    };
    private final String symbol;
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override public String toString() {
        return symbol;
    }

}
