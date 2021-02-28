package com.aki.robot.robot.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.po.Area;
import com.aki.robot.po.Position;
import com.aki.robot.robot.DoRobot;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.InputEvent;

@Component(value = BeanName.doRobt)
public class DoRobtImpl implements DoRobot {
    public static final String beanName = BeanName.doRobt;
    public static final int interval = 100;
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
    public void mouseMove(int afterDelay, Position position) {
        robot.mouseMove(position.getX(), position.getY());
        robot.delay(afterDelay);
    }

    @Override
    public void mouseLeftOnDoubleClick(int delay, Position position) {
        robot.delay(delay);
        robot.mouseMove(position.getX(), position.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @Override
    public void mouseRightOnDoubleClick(int delay, Position position) {
        robot.delay(delay);
        robot.mouseMove(position.getX(), position.getY());
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    @Override
    public void mouseLeftOnClick(int beforeDelay, Position position, int afterDelay) {
        robot.delay(beforeDelay);
        robot.mouseMove(position.getX(), position.getY());
        robot.delay(interval);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(afterDelay);
    }

    @Override
    public void mouseRightOnClick(int delay, Position position) {
        robot.delay(delay);
        robot.mouseMove(position.getX(), position.getY());
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    @Override
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollMouse(int delay, int val) {
        robot.delay(delay);
        robot.mouseWheel(val);
    }

    @Override
    public Color getColor(int delay, Position position) {
        robot.delay(delay);
        Color pixelColor = robot.getPixelColor(position.getX(), position.getY());
        return pixelColor;
    }

    @Override
    public Position getColorPositionOnArea(Area area, Color color, int jingdu) {
        Position position = new Position();
        int x1 = area.getX1();
        int y1 = area.getY1();
        int x2 = area.getX2();
        int y2 = area.getY2();
        for (int y = y1; y <= y2; y += jingdu) {
            for (int x = x1; x <= x2; x += jingdu) {
                position.setX(x);
                position.setY(y);
                Color positionColor = this.getColor(0, position);
                if (positionColor.equals(color)) return position;
            }
        }
        return null;
    }
}
