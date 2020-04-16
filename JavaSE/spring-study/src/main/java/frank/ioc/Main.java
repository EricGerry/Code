package frank.ioc;

import frank.ioc.Duck;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：Eric
 * @Date：2020/4/16 19:19
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        // 新增这里
     /*   Object o = context.getBean("田佳");
        System.out.println(o.getClass());
        System.out.println(o);*/
        Object o = context.getBean("duck");
        System.out.println(o.getClass());
        System.out.println(o);
        Object object = context.getBean("duckShop");
        System.out.println(object);
    }
}
