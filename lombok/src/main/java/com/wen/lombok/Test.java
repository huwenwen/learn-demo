package com.wen.lombok;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huwenwen
 * @since 20/09/2018
 */
public class Test {

    static int[] count = { 0 };

    static int sum = 0;

    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            while (true) {
                if (i % 3 == 0) {
                    synchronized (Test.class) {
                        i++;
                        System.out.println("A");
                    }
                }
            }
        });
        executorService.execute(() -> {
            while (true) {
                if (i % 3 == 1) {
                    synchronized (Test.class) {
                        i++;
                        System.out.println("B");
                    }
                }
            }
        });
        executorService.execute(() -> {
            while (true) {
                if (i % 3 == 2) {
                    synchronized (Test.class) {
                        i++;
                        System.out.println("C");
                    }
                }
            }
        });
    }

    private static void getList(List<Integer> list) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list foreach");
        list.forEach(System.out::println);
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                ++sum;
            }
        }
    }

    private static String getValue() {
        try {
            return "try";
        } finally {
            return "finally";
        }
    }
}
