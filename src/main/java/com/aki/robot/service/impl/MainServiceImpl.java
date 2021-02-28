package com.aki.robot.service.impl;

import cn.hutool.core.img.ImgUtil;
import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import com.aki.robot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = BeanName.mainService)
public class MainServiceImpl implements MainService {
    public static final String beanName = BeanName.mainService;
    @Autowired
    @Qualifier(value = BeanName.inPutUtil)
    InPut inPutUtil;
    @Autowired
    @Qualifier(value = BeanName.doRobt)
    DoRobot doRobot;

//    private int x = 0;
    private int x = 603;
//    private int y = 0;
    private int y = 56;

    public String getMarkDate(){
        return "=======================" + new Date().toString();
    }
    /**
     * 判断是否进入战斗
     * 左上角卡时，黑色会上下动
     * #373322 143 38
     *
     * @return
     */
    public boolean isFighting() {
        if ("#373322".equals(ImgUtil.toHex(doRobot.getColor(0, new Position(143 + x, 38 + y))))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否在倒计时
     * // #A6CAF0 309 246   倒计时2X的2
     * // #A6CAF0 307 289   倒计时1X的1
     * // #FF5F00 339 262   倒计时8的红8
     *
     * @return
     */
    public boolean isCountdown() {
        boolean a1 = "#A6CAF0".equals(ImgUtil.toHex(doRobot.getColor(0, new Position(309 + x, 246 + y))));
        boolean a2 = "#A6CAF0".equals(ImgUtil.toHex(doRobot.getColor(0, new Position(307 + x, 289 + y))));
        boolean a3 = "#FF5F00".equals(ImgUtil.toHex(doRobot.getColor(0, new Position(339 + x, 262 + y))));
        if (a1 || a2 || a3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否有怪物 通过状态栏 变化
     * 128, 494#F8F4E6
     */
    public boolean isHasMonster(){
        if (!"#F8F4E6".equals(ImgUtil.toHex(doRobot.getColor(0, new Position(58 + x, 495 + y))))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查找怪物
     * @return
     */
    public Position findMonsters() {
        Position position;
        int afterWait = 100;
        position = new Position(105 + x, 315 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在前排, 左数位置 1");
            return position;
        }
        position = new Position(159 + x, 256 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在前排, 左数位置 2");
            return position;
        }
        position = new Position(218 + x, 229 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在前排, 左数位置 3");
            return position;
        }
        position = new Position(295 + x, 205 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在前排, 左数位置 4");
            return position;
        }
        position = new Position(346 + x, 179 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在前排, 左数位置 5");
            return position;
        }
        // 后
        position = new Position(28 + x, 263 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在后排, 左数位置 1");
            return position;
        }
        position = new Position(97 + x, 232 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在后排, 左数位置 2");
            return position;
        }
        position = new Position(168 + x, 200 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在后排, 左数位置 3");
            return position;
        }
        position = new Position(233 + x, 148 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在后排, 左数位置 4");
            return position;
        }
        position = new Position(289 + x, 112 + y);
        doRobot.mouseMove(afterWait, position);
        if (this.isHasMonster()) {
            System.out.println(this.getMarkDate());
            System.out.println("怪物在后排, 左数位置 5");
            return position;
        }
        return position;
    }

    // #000001 33 47 33 30 血条
    @Override
    public void doMain() {
        doRobot.sleep(3000);
        System.out.println(this.getMarkDate());
        System.out.println("魔力宝贝自动战斗系统! 3秒后启动!");
        Position hasMonsterPosition = null;
        while (true) {
            int beforeStep = 50 + (int) (Math.random() * 50);
            int afterStep = 250 + (int) (Math.random() * 5);
            if (!this.isFighting()) {
                System.out.println(this.getMarkDate());
                System.out.println("没有战斗，开始走路遇敌人了！");
                hasMonsterPosition = null;
                // 如果不在战斗中
                // 移动1 移动2
                doRobot.mouseLeftOnClick(0, new Position(481 + x, 382 + y), 1000);
                doRobot.mouseLeftOnClick(0, new Position(165 + x, 146 + y), 1000);
            } else {
                // 如果进入战斗
                if (this.isCountdown()) {
                    System.out.println(this.getMarkDate());
                    System.out.println("在战斗中, 开始读秒了！");
                    // 如果开始读秒
                    if (hasMonsterPosition == null) {
                        System.out.println(this.getMarkDate());
                        System.out.println("开始搜索怪物在哪里!");
                        // 寻找怪物位置
                        hasMonsterPosition = this.findMonsters();
                    } else {
                        // 点击怪物
                        if (this.isHasMonster()){
                            System.out.println(this.getMarkDate());
                            System.out.println("开始攻击怪物!");
                            doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, afterStep);
                            doRobot.mouseLeftOnClick(beforeStep, hasMonsterPosition, 0);
                        }else{
                            hasMonsterPosition = null;
                        }
                    }
                } // 如果读秒
            }// 判断是否进入战斗
            //间隔一段时间
            doRobot.sleep(1000);
        }
    }
}
