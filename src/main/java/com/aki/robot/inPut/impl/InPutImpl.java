package com.aki.robot.inPut.impl;

import com.aki.robot.config.BeanName;
import com.aki.robot.inPut.InPut;
import com.aki.robot.po.Area;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;
import java.util.Scanner;

@Component(value = BeanName.inPutUtil)
public class InPutImpl implements InPut {
    public static final String beanName = BeanName.inPutUtil;

    @Override
    public int getUserInPut() {
        Scanner scanner = new Scanner(System.in);
        int keyVal;

        while (true){
            System.out.println("请输入,按键对应的一个字符(仅字母数字):");
            String key = scanner.next();
            //判断是否为一个字符
            if(key.length() != 1){
                System.out.println("请输入一个字符!");
                continue;
            }
            //判断是否为数字或字母
            char c = key.charAt(0);
            keyVal = KeyEvent.getExtendedKeyCodeForChar(c);
            if(keyVal == 0){
                System.out.println("请输入数字或字母!");
                continue;
            }
            break;
        }
        return keyVal;
    }

    @Override
    public Area getArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("x1:");
        int x1 = Integer.parseInt(scanner.next());
        System.out.println("y1:");
        int y1 = Integer.parseInt(scanner.next());
        System.out.println("x2:");
        int x2 = Integer.parseInt(scanner.next());
        System.out.println("y2:");
        int y2 = Integer.parseInt(scanner.next());

        Area area = new Area(x1,y1,x2,y2);
        return area;
    }
}
