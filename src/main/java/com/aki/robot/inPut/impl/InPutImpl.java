package com.aki.robot.inPut.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import org.springframework.stereotype.Component;

@Component(value = BeanName.inPutUtil)
public class InPutImpl implements InPut {
    public static final String beanName = BeanName.inPutUtil;

    @Override
    public void test() {
        System.out.println("say hello");
    }
}
