package study.reactive;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author donghyi.seo
 * @since 2021-04-29
 * study media : https://www.youtube.com/watch?v=DChIxy9g19o
 * 토비 TV 6회 : 스프링 리액티브 웹 개발 (2) - Operators
 * Publisher(pub) -> [Data1] -> Operator(mapPub) -> [Data2] -> Subscriber(logsub)
 * Operator 는 data를 변형시킴 (가공)
 * 1. map ( d1 -> function -> d2 )
 *
 */
@Slf4j
public class ReactivePubSub2 {

    public static void main(String[] args) {
        Iterable<Integer> iter = Stream.iterate(1, a -> a+1)
                .limit(10)
                .collect(Collectors.toList());
        Publisher<Integer> pub = iterPub(iter);
        Publisher<Integer> mapPub = mapPub(pub, s -> s * 10);
        Publisher<Integer> mapPub2 = mapPub(mapPub, s -> -s);    //중개역할자인 mapPub을 재활용
        mapPub2.subscribe(logSub());
    }

    private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> sub) {
                //logsub -> mapPub(subscribe) -> pub(subscribe) 호출함
                //mapPub의 새로 생성한 subscriber 가 logSub에게 중개한다.
                //abstract class 를 만들어 override를 줄인다
                pub.subscribe(new DelegateSub<>(sub) {
                    @Override
                    public void onNext(Integer i) {
                        super.onNext(f.apply(i));
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

    private static Subscriber<Integer> logSub() {
        return new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.info("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer i) {
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


