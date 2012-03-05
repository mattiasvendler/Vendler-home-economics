package se.vendler.economics.util.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Mattias Vendler
 * Date: 3/5/12
 * Time: 8:35 PM
 */
public class BeanLocator {
    private static ApplicationContext applicationContext;
    private static BeanLocator beanLocator;
    private BeanLocator() {
        applicationContext=new ClassPathXmlApplicationContext("classpath*:home-economics-context.xml");
    }
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static <T> T getBean(Class<T> t) {
        if (beanLocator == null) {
            beanLocator=new BeanLocator();
        }
        return (T) getApplicationContext().getBean(t);
    }
}
