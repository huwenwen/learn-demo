package com.wen.leetcode;

/**
 * @author huwenwen
 * @since 2019/9/18
 */
public class Singleton {

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null)
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        return singleton;
    }

}
