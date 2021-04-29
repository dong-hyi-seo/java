package study.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.logging.Level;

@Slf4j
public class FluxScEx {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .publishOn(Schedulers.newSingle("pub")) //consumer 가 느린 작업을 할경우
                .log()
                .subscribeOn(Schedulers.newSingle("sub")) // publisher 가 느린 작업을 할경우
                .log()
                .subscribe(System.out::println);
        System.out.println("exit");
    }
}
