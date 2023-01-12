package study.reactor;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class IntervalEx {

    public static void main(String[] args) {
        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                int no = 0;
                boolean cancelled = false;
                @Override
                public void request(long n) {
                    ScheduledExecutorService exec =
                            Executors.newSingleThreadScheduledExecutor();
                    exec.scheduleAtFixedRate(() -> {
                        if(cancelled){ //cancel 체크 (10보다커지면 스탑!)
                            exec.shutdown();
                            return;
                        }
                        sub.onNext(no++);
                    }, 0, 500, TimeUnit.MILLISECONDS);
                }

                @Override
                public void cancel() {
                    //전역변수 cancel 여부 flag true
                    cancelled = true;
                }
            });
        };

        Publisher<Integer> takePub = sub -> {
            pub.subscribe(new Subscriber<Integer>() {
                int count = 0;
                Subscription subscription;

                @Override
                public void onSubscribe(Subscription s) {
                    subscription = s;
                    sub.onSubscribe(s);
                }

                @Override
                public void onNext(Integer integer) {
                    sub.onNext(integer);
                    if (count ++ > 10) { //10보다 커지면 CANCEL 호출
                        subscription.cancel();
                    }
                }

                @Override
                public void onError(Throwable t) {
                    sub.onError(t);
                }

                @Override
                public void onComplete() {
                    sub.onComplete();
                }
            });
        };

        takePub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.info(Thread.currentThread().getName() + " onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                log.info(Thread.currentThread().getName() + " onNext : {} ", integer);
            }

            @Override
            public void onError(Throwable t) {
                log.info(Thread.currentThread().getName() + " onError : {} ", t);
            }

            @Override
            public void onComplete() {
                log.info(Thread.currentThread().getName() + " oncComplete");
            }
        });
    }
}
