import threads.Thread1;
import threads.Thread2;

import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        Thread1 thread1 = new Thread1("thread 1");
//        //thread1.setDaemon(true);
//        thread1.start();
//
        Thread thread2 = new Thread(() -> {
            for(int i=0;i<5;i++) {
                System.out.println("Running " + "thread 2" + " : " + i);
            }
        }, "thread 2");
        thread2.start();
//
//        System.out.println("Main is exiting!");


/*        try {
            // Print statement
            System.out.println("Entering into Deadlock");
            // Joining the current thread
            Thread.currentThread().join();
            // This statement will never execute
            System.out.println("This statement will never execute");
        }

        // Catch block to handle the exceptions
        catch (InterruptedException e) {
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }*/





        // Thread States
//        Thread thread3 = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                for(int i=1000;i>0;i--);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "states");
//
//        thread3.start();
//
//        while (true) {
//            Thread.State state = thread3.getState();
//            System.out.println(state);
//            if( state == Thread.State.TERMINATED)
//                 break;
//        }
        Object lock1="lock1";
        Object lock2="lock2";

        Thread thread1 = new Thread(()->{
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Lock Acquired, thread 1");
                }
            }
        }, "thread1");


        Thread thread2 = new Thread(()->{
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Lock Acquired, thread 2");
                }
            }
        }, "thread2");

        thread1.start(); thread2.start();
        try {
            thread1.join();             // main will wait till its child completes its execution
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread1.getState() + " : " + thread2.getState());

       // ThreadPoolExecutor


        System.out.println("Main is Exiting");
    }
}