package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileAsyncRunnable implements Runnable {
    public void run() {
        System.out.println("heere");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\twink\\Desktop\\JavaSEConcurrency\\src\\main\\resources\\sample.txt")));
            String line = bufferedReader.readLine();
            do {
                System.out.println(Thread.currentThread().getName() + " " + line);
                line = bufferedReader.readLine();
            } while (line != null);
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}