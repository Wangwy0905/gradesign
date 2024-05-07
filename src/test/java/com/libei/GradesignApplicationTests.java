package com.libei;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradesignApplicationTests {
    /**
     * java 8的语法糖  双冒号 比如User::getName
     *     /**
     *      * int corePoolSize,  核心线程数
     *      * int maximumPoolSize,  最大线程数
     *      * long keepAliveTime,  存活时间
     *      * TimeUnit unit,  单位
     *      * BlockingQueue<Runnable> workQueue) 队列
     *      *  ThreadFactory threadFactory 线程工厂
     *      *   RejectedExecutionHandler handler  拒绝策略
     *      */

    @Test
    public void mappertest() {
        ExecutorService executorService= new ThreadPoolExecutor(3,10,500,
                TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //简化过程
        //1、首先需要一个Runnable对象
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("kang");
//            }
//        });

        //2、Runnable是个函数式接口，因此可以使用lambda进行简化
        //executorService.execute(()-> System.out.println("kang"));

        //3、抽出方法
        //executorService.execute(()->testPrint());
        //最后简化为
        executorService.execute(this::testPrint);
    }
    private void testPrint(){
        System.out.println("那些年我们一起追过的女孩");
    }


}


