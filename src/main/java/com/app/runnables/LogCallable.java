package com.app.runnables;

import java.util.concurrent.Callable;

public class LogCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int n= (int) (Math.random()*10);
        System.out.println(Thread.currentThread().getName()+" : "+n);
        return n;
    }
}
