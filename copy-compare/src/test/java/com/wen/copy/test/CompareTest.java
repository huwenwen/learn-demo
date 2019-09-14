package com.wen.copy.test;

import com.wen.copy.CopyCompare;
import com.wen.copy.SourceBean;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huwenwen
 * @since 16/01/2019
 */
public class CompareTest {

    private SourceBean source(){
        SourceBean source = new SourceBean();
        source.setC1("c1");
//        source.setC2("c1");
//        source.setC3("c1");
//        source.setC4("c1");
//        source.setC5("c1");
//        source.setC6("c1");
//        source.setC7("c1");
//        source.setC8("c1");
//        source.setC9("c1");
//        source.setC10("c1");
//        source.setC11("c1");
//        source.setC12("c1");
//        source.setC13("c1");
//        source.setC14("c1");
//        source.setC15("c1");
        return source;
    }

    @Test
    public void test() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        int size = 100000;
        executor.execute(() -> {
            SourceBean source = source();
            long total = 0;
            for (int i = 0; i < size; i++) {
                long t1 = System.currentTimeMillis();
                CopyCompare.apache(source);
                long t2 = System.currentTimeMillis();
                total = total + (t2 - t1);
            }
            System.out.println("取样" + size + "次apache平均耗时:" + (double) total / size + ",总耗时:" + total);
        });

        executor.execute(() -> {
            SourceBean source = source();
            long total = 0;
            for (int i = 0; i < size; i++) {
                long t1 = System.currentTimeMillis();
                CopyCompare.spring(source());
                long t2 = System.currentTimeMillis();
                total = total + (t2 - t1);
            }
            System.out.println("取样" + size + "次spring平均耗时:" + (double) total / size + ",总耗时:" + total);
        });

        executor.execute(() -> {
            SourceBean source = source();
            long total = 0;
            for (int i = 0; i < size; i++) {
                long t1 = System.currentTimeMillis();
                CopyCompare.cglib(source);
                long t2 = System.currentTimeMillis();
                total = total + (t2 - t1);
            }
            System.out.println("取样" + size + "次cglib平均耗时:" + (double) total / size + ",总耗时:" + total);
        });

        executor.execute(() -> {
            SourceBean source = source();
            long total = 0;
            for (int i = 0; i < size; i++) {
                long t1 = System.currentTimeMillis();
                CopyCompare.cglibX(source);
                long t2 = System.currentTimeMillis();
                total = total + (t2 - t1);
            }
            System.out.println("取样" + size + "次cglibX平均耗时:" + (double) total / size + ",总耗时:" + total);
        });

        executor.execute(() -> {
            SourceBean source = source();
            long total = 0;
            for (int i = 0; i < size; i++) {
                long t1 = System.currentTimeMillis();
                CopyCompare.setter(source);
                long t2 = System.currentTimeMillis();
                total = total + (t2 - t1);
            }
            System.out.println("取样" + size + "次setter平均耗时:" + (double) total / size + ",总耗时:" + total);
        });

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (executor.getActiveCount() == 0) {
                System.out.println("全部执行完毕");
                break;
            }
        }

    }

}
