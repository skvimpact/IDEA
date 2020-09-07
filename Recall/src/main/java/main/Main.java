package main;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Main {
    private static volatile int f = 0;
    public static void main(String[] args) throws InterruptedException {
        f = 3;
        System.out.println(BigDecimal.ROUND_HALF_EVEN);
        System.out.println(BigDecimal.ROUND_HALF_UP);
        System.out.println(Thread.currentThread().getName());
        System.out.println(0.1 + 0.2);
        System.out.println(BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2)));
        System.out.println("I'm alive");
        System.out.println("I'm alive");
        System.out.println("I'm alive");
        System.out.println("I'm alive");
        Object o = new Object();
        o.notify();
//        TimeUnit
//        String h ="d";
//        h.m
//
//
//        Runnable r = () ->
//        {
//            synchronized(FOUR)
//            {
//                result = computePi(50000);
//            }
//        };



        Runnable r = new Runnable() {
            @Override
            public void run()// throws InterruptedException
            {
                Thread thd = Thread.currentThread();
                while (true) {

                    int count = 0;
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        System.out.println("t_" + thd.getState());
                        e.printStackTrace();
//                        Thread.State.
                    }




//                    System.out.printf("%s is %salive and in %s " +
//                                    "state%n",
//                            thd.getName(),
//                            thd.isAlive() ? "" : "not ",
//                            thd.getState());}
                    while (!Thread.interrupted())
                        if (count < 1)
                            System.out.println("t_" + thd.getName());
                }

            }
        };

        Thread t = new Thread(r);
//        System.out.println("main_" + t.getState());
//        t.start();
//        System.out.println("main_" + t.getState());
        while(true){
            Thread.sleep(1100);
            System.out.println("main1_" + t.getState());
            t.interrupt();
            System.out.println("main2_" + t.getState());
        }
//        t.interrupt();
//        Thread.sleep(1000);
//        t.interrupt();
//        Thread.sleep(1000);
//        t.interrupt();
//        Thread.sleep(1000);
//        t.interrupt();
    }
}
