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
        while (true) {
            int beforeStep = 50 + (int) (Math.random() * 50);
            int afterStep = 200 + (int) (Math.random() * 5);
            int random = (int) (Math.random() * 5);
            //0xFFEFE1C6 593 164 自动战斗
            String zd = SpringUtil.toHexFromColor(doRobot.getColor(1000, new Position(593, 164)));
            if (!"0xFFEFE1C6".equals(zd)) {
                // 移动1
                doRobot.mouseLeftOnClick(0, new Position(481 + random, 382 + random) ,1000);
                // 移动2
                doRobot.mouseLeftOnClick(0, new Position(165 + random, 146 + random) ,500);
            } else {
                // 1
                doRobot.mouseLeftOnClick(beforeStep, new Position(28 + random, 263 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(28 + random, 263 + random) ,0);
                // 2
                doRobot.mouseLeftOnClick(beforeStep, new Position(97 + random, 232 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(97 + random, 232 + random) ,0);
                // 3
                doRobot.mouseLeftOnClick(beforeStep, new Position(168 + random, 200 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(168 + random, 200 + random) ,0);
                // 4
                doRobot.mouseLeftOnClick(beforeStep, new Position(233 + random, 148 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(233 + random, 148 + random) ,0);
                // 5
                doRobot.mouseLeftOnClick(beforeStep, new Position(289 + random, 112 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(289 + random, 112 + random) ,0);
                // 6
                doRobot.mouseLeftOnClick(beforeStep, new Position(105 + random, 315 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(105 + random, 315 + random) ,0);
                // 7
                doRobot.mouseLeftOnClick(beforeStep, new Position(159 + random, 256 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(159 + random, 256 + random) ,0);
                // 8
                doRobot.mouseLeftOnClick(beforeStep, new Position(218 + random, 229 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(218 + random, 229 + random) ,0);
                // 9
                doRobot.mouseLeftOnClick(beforeStep, new Position(295 + random, 205 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(295 + random, 205 + random) ,0);
                // 10
                doRobot.mouseLeftOnClick(beforeStep, new Position(346 + random, 179 + random) ,afterStep);
                doRobot.mouseLeftOnClick(beforeStep, new Position(346 + random, 179 + random) ,2000);
            }
        }
    }

    public static void main(String[] args) {
        int i = (int) (Math.random() * 5);
        System.out.println(i);
    }
}
