package com.aki.robot.service.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Area;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import com.aki.robot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.awt.*;

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
//        int key = inPutUtil.getUserInPut();
//        doRobot.press(2000, key);
//        doRobot.mouseLeftOnClick(2000,new Position(100,100));
//        doRobot.mouseRightOnClick(2000,new Position(100,100));
//        doRobot.rollMouse(2000, 50);
//        doRobot.rollMouse(2000,-50);

//        Area area = inPutUtil.getArea();
        Area area = new Area(400, 250, 900, 450);
        Position position = doRobot.getColorPositionOnArea(area, new Color(30, 30, 30), 10);
        System.out.println(position);
//        doRobot.getColor(2000,new Position(610,325));
    }
}
