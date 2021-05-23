package com.aki.robot.service.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import com.aki.robot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = BeanName.mainService2)
public class MainServiceImpl2 implements MainService {
    public static final String beanName = BeanName.mainService2;
    @Autowired
    @Qualifier(value = BeanName.inPutUtil)
    InPut inPutUtil;
    @Autowired
    @Qualifier(value = BeanName.doRobt)
    DoRobot doRobot;


    // #000001 33 47 33 30 血条
    @Override
    public void doMain() {
        while (true) {
            System.out.println("程序启动");
            // 选择附魔
            doRobot.mouseLeftOnClick(1000, new Position(417, 283), 1000);
            // 点击附魔按钮
            doRobot.mouseLeftOnClick(1000, new Position(504, 467), 1000);
            // 点击装备
            doRobot.mouseLeftOnClick(1000, new Position(653, 324), 1000);
            // 点击覆盖
            doRobot.mouseLeftOnClick(1000, new Position(586, 178), 1000);
            //间隔一段时间
            doRobot.sleep(11 * 1000);
        }
    }
}
