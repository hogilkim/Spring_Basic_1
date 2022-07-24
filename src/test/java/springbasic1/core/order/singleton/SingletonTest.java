package springbasic1.core.order.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic1.core.AppConfig;
import springbasic1.core.Member.MemberService;

public class SingletonTest {
    @Test
    @DisplayName("Pure DI Container without Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. Makes new object whenever called
        MemberService memberService1 = appConfig.memberService();

        // 2. Makes new object whenever called
        MemberService memberService2 = appConfig.memberService();

        // 3. check if the referring value is different
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService 1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Using Singleton-pattern applied object")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("Spring Container and Singleton")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberService memberService1 = appConfig.memberService();
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
//        MemberService memberService2 = appConfig.memberService();
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 3. check if the referring value is different
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService 1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);

        // We can see that memberService1 and 2 are same!
    }
}
