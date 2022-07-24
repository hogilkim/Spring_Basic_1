package springbasic1.core.order.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic1.core.AppConfig;
import springbasic1.core.Member.MemberRepository;
import springbasic1.core.Member.MemberService;
import springbasic1.core.Member.MemberServiceImpl;
import springbasic1.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemgerRepository();
        MemberRepository memberRepository2 = orderService.getMemgerRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        // we can see that they are all same even though in AppConfig, returned "NEW" memberRepository
        Assertions.assertThat(memberService.getMemgerRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemgerRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // if it is a pure class, it should be : class ~~.core.AppConfig
        // but instead printed AppConfig$$EnhancerBySpringCGLIB$$de85d203
        // This is modified by Spring, which enables Singleton!
        // Inside this modified code: if Bean exists per method, return ELSE make new Bean and return
    }
}
