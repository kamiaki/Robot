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
         Position hasMonsterPosition = null;
        while (true) {
            int beforeStep = 50 + (int) (Math.random() * 50);
            int afterStep = 250 + (int) (Math.random() * 5);
            int random = (int) (Math.random() * 5);
            //0xFFEFE1C6 593 164 自动战斗
            String zd = SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(593, 164)));
            if (!"0xFFEFE1C6".equals(zd)) {
                // 移动1
                doRobot.mouseLeftOnClick(0, new Position(481 + random, 382 + random), 1000);
                // 移动2
                doRobot.mouseLeftOnClick(0, new Position(165 + random, 146 + random), 1000);
            } else {
                // 如果是 读秒的时候     // 315 261 倒计时牌子 0xFFA6CAF0
                if ("0xFFA6CAF0".equals(SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(315, 261))))) {
                    if (hasMonsterPosition != null) {
                        doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, afterStep);
                        // 判断有没有怪物 0xFFF8F4E6 59, 494
                        if (SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = null;
                            continue;
                        }
                        doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, 0);
                    } else {
                        Position position;
                        // 6 前排
                        position = new Position(105 + random, 315 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 7
                        position = new Position(159 + random, 256 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 8
                        position = new Position(218 + random, 229 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 9
                        position = new Position(295 + random, 205 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 10
                        position = new Position(346 + random, 179 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 1
                        position = new Position(28 + random, 263 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 2
                        position = new Position(97 + random, 232 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 3
                        position = new Position(168 + random, 200 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 4
                        position = new Position(233 + random, 148 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }
                        // 5
                        position = new Position(289 + random, 112 + random);
                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
                            hasMonsterPosition = position;
                            continue;
                        }

                    }
                } // 如果读秒
                //间隔一段时间
                doRobot.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        int i = (int) (Math.random() * 5);
        System.out.println(i);
    }
}
