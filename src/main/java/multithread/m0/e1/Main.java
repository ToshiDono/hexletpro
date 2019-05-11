package multithread.m0.e1;

import multithread.m0.e0.MockLoader;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        firstWay();
        secondWay();
    }

    public static void firstWay(){
        final long before = System.currentTimeMillis();
        final Thread loader = new TextLoaderThread(new MockLoader("thread1"));
        //        runnableLoader.run();
        loader.start();
        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d\n", (after - before)/1_000);
    }

    public static void secondWay(){
        final long before = System.currentTimeMillis();
        final Runnable runnableLoader = new TextLoaderThread(new MockLoader("thread1"));
        final Thread thread = new Thread(runnableLoader);
        thread.start();
        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d\n", (after - before)/1_000);
    }
}
