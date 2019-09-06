package com.aki.robot.util;

import com.aki.robot.service.MainService;
import com.aki.robot.service.impl.MainServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    private final static String APP_CONTEXT = "applicationContext-Robot.xml";

    /**
     * 获取 bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        ApplicationContext context = new ClassPathXmlApplicationContext(APP_CONTEXT);
        Object bean = context.getBean(beanName);
        return bean;
    }
}
