package study.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class LoadTest {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/callable";
        StopWatch main = new StopWatch();
        main.start();


    }
}
