package study;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 토비의 봄 TV 7회 - 리액티브 스프링 웹 개발 (3) - Reactive Streams - Schedulers
 * 보통 publisher 와 subscriber를 같은 thread안에 두지 않는다.
 */
public class SchedulerEx {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SchedulerEx.class);

        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                //publiser와 subscriber사이의 이 action을 별도의 thread에서 돌게 하고 싶다
                //Scheduler사용
                @Override
                public void request(long n) {
                    sub.onNext(1);
                    sub.onNext(2);
                    sub.onNext(3);
                    sub.onNext(4);
                    sub.onNext(5);
                    sub.onComplete();
                }

                @Override
                public void cancel() {

                }
            });
        };

        pub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                logger.info("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                logger.info("onNext : {} ", integer);
            }

            @Override
            public void onError(Throwable t) {
                logger.info("onError : {} ", t);
            }

            @Override
            public void onComplete() {
                logger.info("oncComplete");
            }
        });
    }
}
