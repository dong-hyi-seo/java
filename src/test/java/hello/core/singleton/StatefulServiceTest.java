package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefullServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService st1 = ac.getBean(StatefulService.class);
        StatefulService st2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        st1.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        st1.order("userA", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        int price = st1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(st1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}
