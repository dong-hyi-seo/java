package study.reactor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * Future 함수
 * 비동기 작업을 수행하고 그 결과를 가지고있는 함수
 * 옛날 기술들임 .. 더좋은것이 많음
 */
@Slf4j
public class FutureEx {

    interface SuccessCallback {
        void onSuccess(String result);
    }

    interface ExceptionCallback {
        void onError(Throwable t);
    }

    //submit 하무는 callable 인터페이스를 받는다. callable은 try catch도해줌
    //callback
    public static class CallbackFutureTask extends FutureTask<String> {
        SuccessCallback sc;
        ExceptionCallback ec;

        public CallbackFutureTask(Callable<String> callable, SuccessCallback sc, ExceptionCallback ec) {
            super(callable);
            this.sc = Objects.requireNonNull(sc);
            this.ec = Objects.requireNonNull(ec);
        }

        @Override
        protected void done() {
            try {
                sc.onSuccess(get());
            } catch (InterruptedException e){
                //신호만 주면 되
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                ec.onError(e.getCause());
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        CallbackFutureTask f = new CallbackFutureTask(() -> {
            Thread.sleep(2000);
            log.info("hello");
            return "hello";
        }, res -> System.out.println("Result : " + res), e -> System.out.println("Error : " + e.getMessage()));
        es.execute(f);
        es.shutdown();

    }
}
