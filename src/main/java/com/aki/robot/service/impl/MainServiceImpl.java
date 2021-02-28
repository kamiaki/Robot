package com.aki.robot.service.impl;

import cn.hutool.core.img.ImgUtil;
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

    private int x = 0;
    private int y = 0;

    /**
     * 判断是否进入战斗
     * 左上角卡时，黑色会上下动
     * #373322 143 38
     * @return
     */
    public boolean isFighting() {
        if ("#373322".equals( ImgUtil.toHex(doRobot.getColor(0, new Position(143 + x, 38 + y))))){
            System.out.println("正处在战斗中！");
            return true;
        }else{
            System.out.println("没有处在战斗中！");
            return false;
        }
    }

    // #000001 33 47 33 30 血条
    @Override
    public void doMain() {
        System.out.println("魔力宝贝自动战斗系统启动!");
        Position hasMonsterPosition = null;
        boolean fighting = this.isFighting();
//        while (false) {
//            int beforeStep = 50 + (int) (Math.random() * 50);
//            int afterStep = 250 + (int) (Math.random() * 5);
//            int offset = (int) (Math.random() * 5);

//            //0xFFEFE1C6 593 164 自动战斗
//            String zd = SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(593, 164)));
//            if (!"0xFFEFE1C6".equals(zd)) {
//                // 移动1
//                doRobot.mouseLeftOnClick(0, new Position(481 + offset, 382 + offset), 1000);
//                // 移动2
//                doRobot.mouseLeftOnClick(0, new Position(165 + offset, 146 + offset), 1000);
//            } else {
//                // 如果是 读秒的时候     // 315 261 倒计时牌子 0xFFA6CAF0
//                if ("0xFFA6CAF0".equals(SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(315, 261))))) {
//                    if (hasMonsterPosition != null) {
//                        doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, afterStep);
//                        // 判断有没有怪物 0xFFF8F4E6 59, 494
//                        if (SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = null;
//                            continue;
//                        }
//                        doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, 0);
//                    } else {
//                        Position position;
//                        // 6 前排
//                        position = new Position(105 + offset, 315 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 7
//                        position = new Position(159 + offset, 256 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 8
//                        position = new Position(218 + offset, 229 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 9
//                        position = new Position(295 + offset, 205 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 10
//                        position = new Position(346 + offset, 179 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 1
//                        position = new Position(28 + offset, 263 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 2
//                        position = new Position(97 + offset, 232 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 3
//                        position = new Position(168 + offset, 200 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 4
//                        position = new Position(233 + offset, 148 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//                        // 5
//                        position = new Position(289 + offset, 112 + offset);
//                        doRobot.mouseLeftOnClick(beforeStep, position, afterStep);
//                        doRobot.mouseLeftOnClick(beforeStep, position, 0);
//                        if (!SpringUtil.toHexFromColor(doRobot.getColor(0, new Position(59, 494))).equals("0xFFF8F4E6")) {
//                            hasMonsterPosition = position;
//                            continue;
//                        }
//
//                    }
//                } // 如果读秒
//                //间隔一段时间
//                doRobot.sleep(1000);
//            }
//        }
    }
}
