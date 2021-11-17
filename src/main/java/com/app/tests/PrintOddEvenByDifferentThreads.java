package com.app.tests;

public class PrintOddEvenByDifferentThreads {
    public static void main(String[] args) {
    Printer printer=new Printer(true,true,1,2);


        new PrintOdd(printer).start();
        new PrintEven(printer).start();
    }

    public static  class Printer
    {
        boolean printEven;
        boolean printOdd;
        int nextOdd;
        int nextEven;

        public Printer(boolean printEven, boolean printOdd, int nextOdd, int nextEven) {
            this.printEven = printEven;
            this.printOdd = printOdd;
            this.nextOdd = nextOdd;
            this.nextEven = nextEven;
        }

        synchronized void printEven()
        {
            while(!printEven)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread()+" "+nextEven);
            nextEven+=2;
            printOdd=true;
            printEven=false;
            notifyAll();
        }

        synchronized void printOdd()
        {
            while(!printOdd)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread()+" "+nextOdd);
            nextOdd+=2;
            printOdd=false;
            printEven=true;
            notifyAll();
        }

        synchronized public int getNextOdd() {
            return nextOdd;
        }

        synchronized public int getNextEven() {
            return nextEven;
        }
    }
public static  class PrintOdd extends Thread{
        Printer printer;
        PrintOdd(Printer p)
        {
            printer=p;
        }
        @Override
    public void run()
        {
            while (printer.getNextOdd()<=100)
            printer.printOdd();

        }
}

    public static  class PrintEven extends Thread{
        Printer printer;
        PrintEven(Printer p)
        {
            printer=p;
        }
        @Override
        public void run()
        {
            while(printer.getNextEven()<=100)
            printer.printEven();

        }
    }
}
