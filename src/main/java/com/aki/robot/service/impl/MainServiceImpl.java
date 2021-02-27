package com.aki.robot.service.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import com.aki.robot.service.MainService;
import com.aki.robot.util.SpringUtil;
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

    // #000001 33 47 33 30 血条
    @Override
    public void doMain() {
        int step = 100 + (int) (Math.random() * 100);
        int random = (int) (Math.random() * 5);
        while (true) {
            //0xFFEFE1C6 593 164 自动战斗
            String zd = SpringUtil.toHexFromColor(doRobot.getColor(1000, new Position(593, 164)));
            if (!"0xFFEFE1C6".equals(zd)) {
                // 移动1
                doRobot.mouseLeftOnClick(0, new Position(487 + random, 145 + random) ,1000);
                // 移动2
                doRobot.mouseLeftOnClick(0, new Position(180 + random, 386 + random) ,500);
            } else {
                // 1
                doRobot.mouseLeftOnClick(step, new Position(28 + random, 263 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(28 + random, 263 + random) ,0);
                // 2
                doRobot.mouseLeftOnClick(step, new Position(97 + random, 232 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(97 + random, 232 + random) ,0);
                // 3
                doRobot.mouseLeftOnClick(step, new Position(168 + random, 200 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(168 + random, 200 + random) ,0);
                // 4
                doRobot.mouseLeftOnClick(step, new Position(233 + random, 148 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(233 + random, 148 + random) ,0);
                // 5
                doRobot.mouseLeftOnClick(step, new Position(289 + random, 112 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(289 + random, 112 + random) ,0);
                // 6
                doRobot.mouseLeftOnClick(step, new Position(105 + random, 315 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(105 + random, 315 + random) ,0);
                // 7
                doRobot.mouseLeftOnClick(step, new Position(159 + random, 256 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(159 + random, 256 + random) ,0);
                // 8
                doRobot.mouseLeftOnClick(step, new Position(218 + random, 229 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(218 + random, 229 + random) ,0);
                // 9
                doRobot.mouseLeftOnClick(step, new Position(295 + random, 205 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(295 + random, 205 + random) ,0);
                // 10
                doRobot.mouseLeftOnClick(step, new Position(346 + random, 179 + random) ,step);
                doRobot.mouseLeftOnClick(step, new Position(346 + random, 179 + random) ,2000);
            }
        }
    }

    public static void main(String[] args) {
        int i = (int) (Math.random() * 5);
        System.out.println(i);
    }
}
