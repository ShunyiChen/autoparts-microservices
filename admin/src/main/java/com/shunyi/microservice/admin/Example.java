package com.shunyi.microservice.admin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Asus
 * @create 2021-03-25 21:29
 */
public class Example {

    public static void main(String[] args) {

        //创建线程池,参数是创造的线程数量
        ExecutorService pool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            final int j = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    //执行任务
                    Thread t = new Thread(new Task(j));
                    t.start();
                    System.out.println("线程"+j+"执行完");
                }
            });
        }
        pool.shutdown();
//        //所有线程执行完毕,会跳出循环,线程内任务没有执行完,不会跳出
//        while (!pool.isTerminated()) {
//        }
    }
}

class Task implements Runnable {

    int id = 0;
    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("子线程"+id);
    }
}
