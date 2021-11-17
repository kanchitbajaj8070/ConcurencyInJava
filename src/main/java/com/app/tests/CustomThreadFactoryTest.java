package com.app.tests;

import com.app.CustomThreadFactory;
import com.app.runnables.LogCallable;
import com.app.runnables.ReadFileAsyncRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CustomThreadFactoryTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10,new CustomThreadFactory());
        for(int i=1;i<=20;i++)
        executorService.submit(new LogCallable());
        System.out.println("done");
            executorService.shutdown();

    }
}
