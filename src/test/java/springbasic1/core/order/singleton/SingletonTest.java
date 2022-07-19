package springbasic1.core.order.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbasic1.core.AppConfig;
import springbasic1.core.Member.MemberService;

public class SingletonTest {
    @Test
    @DisplayName("Pure DI Container without Spring")
    void pureContainer(){
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
}
