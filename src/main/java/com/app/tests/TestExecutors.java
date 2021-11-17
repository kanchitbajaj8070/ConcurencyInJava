package com.app.tests;

import com.app.beans.User;
import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        UserDao userDao=new UserDao();
        for(User user:getUsersFromFile()) {
            Future<Integer> future=executorService.submit(new UserProcessor(user, userDao));
            System.out.println(future.get());

        }



        executorService.shutdown();
        //System.out.println(getUsersFromFile());

    }
    public static  List<User> getUsersFromFile()
    {
        List<User> users=new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\twink\\Desktop\\JavaSEConcurrency\\src\\main\\resources\\new_users.txt")));
            String line=bufferedReader.readLine();
            do
            {
              // System.out.println(Thread.currentThread().getName()+" "+line);
                String[]words=line.split(",");
                users.add(new User(Integer.valueOf(words[2]),words[0],words[1]));
                line =bufferedReader.readLine();
            }while (line!=null);
            bufferedReader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
