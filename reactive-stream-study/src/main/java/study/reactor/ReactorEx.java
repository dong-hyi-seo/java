package study.reactor;

import reactor.core.publisher.Flux;

public class ReactorEx {

    public static void main(String[] args) {
        //flux = publisher
        Flux.<Integer>create(e -> {
            e.next(1);
            e.next(2);
            e.next(3);
            e.complete();
        })
        .log() // 위와 아래 subscribe 사이의 로그를 찍어줌
        .map(s->s*10)
        .log()
        .reduce(0, (a, b) -> a+b)
        .log()
        .subscribe(System.out::println);
    }
}
