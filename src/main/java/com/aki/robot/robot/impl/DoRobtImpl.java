package com.aki.robot.robot.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.robot.DoRobot;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;

@Component(value = BeanName.doRobt)
public class DoRobtImpl implements DoRobot {
    public static final String beanName = BeanName.doRobt;
    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void press(int delay, int key) {
        robot.delay(delay);
        robot.keyPress(key);
    }
}
