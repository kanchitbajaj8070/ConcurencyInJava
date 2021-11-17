package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;

public class ReadFileAsyncTask extends Thread {

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\twink\\Desktop\\JavaSEConcurrency\\src\\main\\resources\\sample.txt")));
            String line=bufferedReader.readLine();
           do
            {
                System.out.println(Thread.currentThread().getName()+" "+line);
                line =bufferedReader.readLine();
               }while (line!=null);
            bufferedReader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
