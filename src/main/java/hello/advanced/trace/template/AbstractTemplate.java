package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * 이를 해결하는 방법 중하나는 템플릿 메서드 패턴을 사용하는것이다
 * 템플릿메서드 패턴은 추상화클래스에 공통로직을 구현!
 * 변하지않는부분과 변하는부분을 분리하는것! 그리고 중복제거!
 *
 * 하지만.. 상속의 단점도 가지고간다. 특히 자식 클래스가 부모 클래스와 컴파일 시점에 강하게 결합되는 문제가 있다.
 * 이것은 의존관계에 대한 문제이다. 자식 클래스 입장에서는 부모 클래스의 기능을 전혀 사용하지 않는다.
 * 이번 장에서 지금까지 작성했던 코드를 떠올려보자. 자식 클래스를 작성할 때 부모 클래스의 기능을 사용한 것이 있던가??
 * 그럼에도 불구하고 템플릿 메서드 패턴을 위해 자식 클래스는 부모 클래스를 상속 받고있다.
 *
 * 상속을 받는 다는 것은 특정 부모 클래스를 의존 하고 있다는 것이다. 자식 클래스의 extends 다음에 바로 부모 클래스가 코드상에 지정되어있다.
 * 따라서 부모 클래스의 기능을 사용하든 사용하지 않든 간에 부모 클래스를 강하게 의존하게 된다. 여기서 강하게 의존한다는 뜻은
 * 자식클래스의 코드에 부모클래스의 코드가 명확하게 적혀 있다는 뜻이다.
 *
 * 이러한 부분을 해결하려면 ?? 전략 패턴을 사용하면된다!
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T excute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            //로직 호출되어야함
            T result = call();

            trace.end(status);
            return result;

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
