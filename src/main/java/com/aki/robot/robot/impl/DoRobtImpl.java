package com.aki.robot.robot.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.InputEvent;
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

    @Override
    public void mouseLeftOnClick(int delay, Position position) {
        robot.mouseMove(position.getX(), position.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @Override
    public void mouseRightOnClick(int delay, Position position) {
        robot.mouseMove(position.getX(), position.getY());
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    @Override
    public void rollMouse(int delay, int val) {
        robot.delay(delay);
        robot.mouseWheel(val);
    }

    @Override
    public void getColor(int delay, Position position) {
        Color pixelColor = robot.getPixelColor(position.getX(), position.getY());
        System.out.println(pixelColor.toString());
        System.out.println(pixelColor.getRed());
        System.out.println(pixelColor.getGreen());
        System.out.println(pixelColor.getBlue());
    }
}
