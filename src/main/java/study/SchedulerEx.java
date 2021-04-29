package study;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 토비의 봄 TV 7회 - 리액티브 스프링 웹 개발 (3) - Reactive Streams - Schedulers
 * 보통 publisher 와 subscriber를 같은 thread안에 두지 않는다.
 *
 * 아래 별도 쓰레드 생성하여 비동기처리 하는 방법
 * subscribeOn : publisher 가 느린 로직을 가지고있을때 사용(subOnPub)
 * publishOn : subscriber가 느린 로직을 가지고있을때 사용(pubOnPub)
 *             멀티쓰레드방식은 지원안하며 단일쓰레드만 지원함 (subscriber thread)
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
                    logger.info(Thread.currentThread().getName() + " request");
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
        //pub
       /* Publisher<Integer> subOnPub = sub -> {
            ExecutorService es = Executors.newSingleThreadExecutor();
            es.execute(() -> pub.subscribe(sub));
        };*/

        Publisher<Integer> pubOnPub = sub -> {
            pub.subscribe(new Subscriber<Integer>() {
                ExecutorService es = Executors.newSingleThreadExecutor();
                @Override
                public void onSubscribe(Subscription s) {
                    sub.onSubscribe(s);
                }

                @Override
                public void onNext(Integer integer) {
                    es.execute(() -> sub.onNext(integer));
                }

                @Override
                public void onError(Throwable t) {
                    es.execute(() -> sub.onError(t));
                }

                @Override
                public void onComplete() {
                    es.execute(() -> sub.onComplete());
                }
            });
        };

        pubOnPub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                logger.info(Thread.currentThread().getName() + " onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                logger.info(Thread.currentThread().getName() + " onNext : {} ", integer);
            }

            @Override
            public void onError(Throwable t) {
                logger.info(Thread.currentThread().getName() + " onError : {} ", t);
            }

            @Override
            public void onComplete() {
                logger.info(Thread.currentThread().getName() + " oncComplete");
            }
        });
        System.out.println(Thread.currentThread().getName() + " exit");
    }
}
