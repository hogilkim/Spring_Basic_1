package springbasic1.core.beanDefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic1.core.AppConfig;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean Syste Meta-info check")
    void findApplicadtionBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDenitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
