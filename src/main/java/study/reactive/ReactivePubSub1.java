package study.reactive;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.*;

/*
reative-stream 는 java 8의 Observable를 더 좋게 쓰기위해 변형한 것
webflux 는 reactive-stream을 간단하게 쓸수있게 한 프레임워크
 */
public class ReactivePubSub1 {
    public static void main(String[] args) throws InterruptedException {
        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);
        ExecutorService es = Executors.newCachedThreadPool();

        // reactive 코딩은 event 방식의 구현 방법
        Publisher<Integer> p = new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {
                Iterator<Integer> it = itr.iterator();
                //필수적으로 onSubscribe onNext* (onError | onComplete)를 호출 한다.
                //subscription은 publisher 와 subscriber 사이에 요청 개수 및 속도 컨트롤을해준다.
                subscriber.onSubscribe(new Subscription() {
                    //request는 subscriber가 1개 또는 무한개 요청하는 부분
                    @Override
                    public void request(long n) {
                        //es(thread)로부터 결과값을 받을떄 Future 비동기 작업의 결과를 받는다. 또한 중간에 작업을 취소가 가능하다.
                        es.execute(() -> {
                            int i = 0;
                            while (i++ <  n) {
                                if(it.hasNext()){
                                    //subscriber에 전달
                                    subscriber.onNext(it.next());
                                }else {
                                    subscriber.onComplete();
                                    break;
                                }
                            }
                        });
                    }
                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> s = new Subscriber<Integer>() {
            //on next에서도 subscription 을통해서 request하기 위해 전역변수로 생성
            Subscription subscription;

            // pub가 100만건을 던질떄 sub 는 5초마다의 동작이 진행될때 중간에 버퍼가 필요
            // pub가 cache에 저장하고 sub가 버퍼를 적용 하면서 천천히가져가 수행하면 메모리가 유지
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                //최초 request를 해야함. (몇개를 줘라) 개수요청
                this.subscription = s;
                this.subscription.request(1);
            }

            //데이터를 하나씩 가져옴
            //1개씩 받고 다음꺼 하나줘 ~
            @Override
            public void onNext(Integer item) {
                // 항상 Subscriber는 publisher로부터 sequence로 받는다
                System.out.println(Thread.currentThread().getName() + " onNext " + item);
                this.subscription.request(1);
            }

            //try catch 가 필요 없음
            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError" + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        p.subscribe(s);
        es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdown();
    }
}
