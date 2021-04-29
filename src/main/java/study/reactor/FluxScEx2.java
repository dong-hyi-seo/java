package study.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FluxScEx2 {

    public static void main(String[] args) throws InterruptedException {
        //interval 어떤 주기를 가지고 숫자 증가 (무한대로)- 강제종료전까지
       Flux.interval(Duration.ofMillis(500)) //데몬쓰레드 timer 실행됨
               .take(10) //10개만 받고 종료한다!
               .subscribe(System.out::println);

       //데몬 쓰레드 vs 유저쓰레드

        //sleep을 시켜야
        System.out.println("exit");
        TimeUnit.SECONDS.sleep(10);
    }
}
