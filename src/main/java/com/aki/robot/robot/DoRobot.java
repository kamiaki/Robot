package com.aki.robot.robot;

import com.aki.robot.po.Position;

public interface DoRobot {
    /**
     * 延时 delay 按下 key
     * @param delay
     * @param key
     */
    void press(int delay, int key);

    void mouseLeftOnClick(int delay,Position position);

    void mouseRightOnClick(int delay, Position position);

    void rollMouse(int delay, int val);

    void getColor(int delay,Position position);
}
