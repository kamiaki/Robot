package com.aki.robot.service.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import com.aki.robot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = BeanName.mainService)
public class MainServiceImpl implements MainService {
    public static final String beanName = BeanName.mainService;
    @Autowired
    @Qualifier(value = BeanName.inPutUtil)
    InPut inPutUtil;
    @Autowired
    @Qualifier(value = BeanName.doRobt)
    DoRobot doRobot;

    @Override
    public void doMain() {
        while (true) {
            System.out.println("程序启动");
            // 选择附魔
            doRobot.mouseLeftOnClick(500, new Position(403, 282), 500);
            // 点击附魔按钮
            doRobot.mouseLeftOnClick(500, new Position(504, 467), 500);
            // 点击装备
            doRobot.mouseLeftOnClick(500, new Position(651, 433), 500);
            // 点击覆盖
            doRobot.mouseLeftOnClick(500, new Position(590, 191), 500);
            //间隔一段时间
            doRobot.sleep(6 * 1000);
        }
    }
}
