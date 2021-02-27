package com.aki.robot.robot;

import com.aki.robot.po.Area;
import com.aki.robot.po.Position;

import java.awt.*;

public interface DoRobot {
    /**
     * 延时 delay 按下 key
     *
     * @param delay
     * @param key
     */
    void press(int delay, int key);

    void mouseMove(int delay, Position position);

    void mouseLeftOnDoubleClick(int delay, Position position);

    void mouseRightOnDoubleClick(int delay, Position position);

    void mouseLeftOnClick(int delay, Position position);

    void mouseRightOnClick(int delay, Position position);

    /**
     * 滚轮移动 -上 +下
     * @param delay
     * @param val
     */
    void rollMouse(int delay, int val);

    Color getColor(int delay, Position position);

    /**
     * 获取给定颜色的坐标,在给定范围
     */
    Position getColorPositionOnArea(Area area, Color color, int jingdu);
}
