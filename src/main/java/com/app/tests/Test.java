package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.ReadFileAsyncTask;

public class Test {
    public static void main(String[] args) {
        //System.out.println("test");
        Thread t1 = new ReadFileAsyncTask();//NEW
        Thread t2 = new ReadFileAsyncTask();
        Thread t3 = new ReadFileAsyncTask();
        t1.start();//RUN STATE
        t2.start();
        t3.start();
        //RUNNING
        //WAIT/BLOCK
        //TERMINATED/DEAD

        /*
        * We will see we get random ordering . Run is alwasy called by JVM , you can only start it*/

    }
}
