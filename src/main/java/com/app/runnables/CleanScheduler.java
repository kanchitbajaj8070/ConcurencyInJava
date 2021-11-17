package com.app.runnables;

import java.io.File;

public class CleanScheduler implements Runnable {
    @Override
    public void run() {
        File folder=new File("C:\\Users\\twink\\Desktop\\JavaSEConcurrency\\src\\main\\resources\\serverLogs");
        File[] files=folder.listFiles();
        System.out.println("executing scheduler");
        //delete all files older than 1 minutes
        for(File file:files)
        {
            if(System.currentTimeMillis()-file.lastModified()>(1*60*1000))
            {
                System.out.println("deleting "+ file.getName());
                file.delete();
            }
        }
    }
}
