package springbasic1.core.order.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: user A ordered 10
        statefulService1.order("userA", 10);

        // ThreadB: user B ordered 20
        statefulService2.order("userB", 20);

        // ThreadA: user A checks price
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // User A expected 10, but got 20 -> b/c statefulService1 & statefulService2 refers to same thing

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}