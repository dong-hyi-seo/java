package study.reactive;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Operators(2)
 */
@Slf4j
public class ReactivePubSub3 {
    public static void main(String[] args) {
        Iterable<Integer> iter = Stream.iterate(1, a -> a+1)
                .limit(10)
                .collect(Collectors.toList());
        Publisher<Integer> pub = iterPub(iter);

        //BiFunction 인자값을 세개 받아 하나의 리턴을 하는 함수 인터페이스 (인자값은 세개를 받는다)
        Publisher<Integer> reducePub = reducePub(pub, 0, (BiFunction<Integer, Integer, Integer>)(a, b) -> a+b);
        reducePub.subscribe(logSub());
    }

    private static Publisher<Integer> reducePub(Publisher<Integer> pub, int init, BiFunction<Integer, Integer, Integer> bf) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> sub) {
                pub.subscribe(new DelegateSub<>(sub){
                    int result = init;
                    @Override
                    public void onNext(Integer i) {
                        result = bf.apply(result, i);
                    }
                    @Override
                    public void onComplete() {
                        sub.onNext(result);
                        sub.onComplete();
                    }
                });
            }
        };
    }

    private static Publisher<Integer> iterPub(Iterable<Integer> iter) {
        //데이터를 받는것 (subscribe)
        return sub -> sub.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                try {
                    iter.forEach(sub::onNext);
                    sub.onComplete();
                } catch (Throwable t){
                    sub.onError(t);
                }
            }

            //subscriber가 구독을 취소
            @Override
            public void cancel() {

            }
        });
    }

    private static <T> Subscriber<T> logSub() {
        return new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.info("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(T i) {
                log.info("onNext : {} ", i);
            }

            @Override
            public void onError(Throwable t) {
                log.info("onError : {} ", t);
            }

            @Override
            public void onComplete() {
                log.info("onComplete");

            }
        };
    }
}
