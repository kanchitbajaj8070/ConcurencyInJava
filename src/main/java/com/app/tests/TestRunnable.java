package com.app.tests;

import com.app.runnables.ReadFileAsyncRunnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnable {
    public static void main(String[] args) {
        ReadFileAsyncRunnable readFileAsyncRunnable=new ReadFileAsyncRunnable() ;
        //readFileAsyncRunnable.run();
        Runnable runnable=()->{
            System.out.println(Thread.currentThread()+"--"+"testing lambda runnable");
        };
        Thread t1=new Thread(runnable);
//        t1.start();
//        Executor executor= Executors.newSingleThreadExecutor();
//        executor.execute(runnable);
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        executorService.submit(runnable);
        executorService.shutdown();
    }
}
