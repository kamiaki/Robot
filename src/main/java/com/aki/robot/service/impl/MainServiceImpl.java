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
//        int key = inPutUtil.getUserInPut();
//        doRobot.press(2000, key);
//        doRobot.mouseLeftOnClick(2000,new Position(100,100));
//        doRobot.mouseRightOnClick(2000,new Position(100,100));
//        doRobot.rollMouse(2000, 50);
//        doRobot.rollMouse(2000,-50);

//        Area area = inPutUtil.getArea();
//        Area area = new Area(400, 250, 900, 450);
//        Position position = doRobot.getColorPositionOnArea(area, new Color(30, 30, 30), 10);
//        System.out.println(position);
//        doRobot.getColor(2000,new Position(610,325));
        int step = 100;
        //97 304
        // #000001 33 47 33 30
        while (true){
//            Color color = doRobot.getColor(1000, new Position(33, 47));
//            Color color2 = doRobot.getColor(1000, new Position(33, 30));
//            String s = SpringUtil.toHexFromColor(color);
//            String s2 = SpringUtil.toHexFromColor(color2);
//            System.out.println(s);
//            System.out.println(color);
//            System.out.println(s2);
//            System.out.println(color2);
//            // 1
            doRobot.mouseLeftOnClick(step, new Position(97, 304));
            // 2
            doRobot.mouseLeftOnClick(step, new Position(163, 261));
            // 3
            doRobot.mouseLeftOnClick(step, new Position(211, 217));

            // 4
            doRobot.mouseLeftOnClick(step, new Position(291, 208));

            // 5
            doRobot.mouseLeftOnClick(step, new Position(359, 144));

            // 6
            doRobot.mouseLeftOnClick(step, new Position(58, 273));

            // 7
            doRobot.mouseLeftOnClick(step, new Position(114, 232));

            // 8
            doRobot.mouseLeftOnClick(step, new Position(184, 189));

            // 9
            doRobot.mouseLeftOnClick(step, new Position(248, 139));
            // 10
            doRobot.mouseLeftOnClick(step, new Position(301, 95));

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
