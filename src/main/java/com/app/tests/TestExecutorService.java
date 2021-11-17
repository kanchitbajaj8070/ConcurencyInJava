package com.app.tests;

import com.app.runnables.LogCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks=new ArrayList<>();
        for(int i=1;i<=20;i++)
            tasks.add(new LogCallable());

    List<Future<Integer>> futures=executorService.invokeAll(tasks);
        System.out.println("********futures**************");
    for(Future<Integer> f:futures)
    {
        System.out.println(f.get());
    }
        System.out.println("*********88INVOKE ANY *********");
    Integer e=executorService.invokeAny(tasks);
        System.out.println(e);
        executorService.shutdown();
        try {
            System.out.println(executorService.awaitTermination(2, TimeUnit.SECONDS));
           // throw new InterruptedException();
        }
        catch (InterruptedException exception)
        {
            executorService.shutdownNow();
            System.out.println("force shutdown");
        }
        System.out.println(executorService.isShutdown());
    }
}
