package com.aki.robot;

import com.aki.robot.service.MainService;
import com.aki.robot.service.impl.MainServiceImpl;
import com.aki.robot.util.SpringUtil;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        MainService mainService = (MainServiceImpl) SpringUtil.getBean(MainServiceImpl.beanName);
        mainService.doMain();
    }
}
