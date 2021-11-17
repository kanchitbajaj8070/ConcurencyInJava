package com.app.tests;

import com.app.runnables.CleanScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestSchedulers {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // scheduledExecutorService.schedule(new CleanScheduler(),5, TimeUnit.SECONDS);
    //scheduledExecutorService.scheduleAtFixedRate(new CleanScheduler(),5,2,TimeUnit.SECONDS);
scheduledExecutorService.scheduleWithFixedDelay(new CleanScheduler(),2,2,TimeUnit.SECONDS);
    }
}
