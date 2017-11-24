package com.ahacool.mvp.utils;

/**
 * Description: TODO
 *
 * @author: moto
 * @time: 17/11/24 下午8:48
 */

public class Utils {

    public static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
