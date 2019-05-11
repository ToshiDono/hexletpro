package multithread.m0.e1;

import multithread.m0.e0.MockLoader;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        firstWay();
//        secondWay();
        checkHW();
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

    public static void checkHW(){
        final int[] test1 = {1, 2, 3};
        final int expectedResult1 = 6;
        final int[] test2 = {4, 5, 6};
        final int expectedResult2 = 15;
        validateSummThread(test1, expectedResult1);
        validateSummThread(test2, expectedResult2);
    }

    private static void validateSummThread(
            final int[] input,
            final int expectedResult) {
        final SumThread t = new SumThread(input);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int actualResult = t.getResult();
        if (actualResult != expectedResult) {
            throw new RuntimeException(String.format("SumThread calculates" +
                            "incorrect summ for the input: %s," +
                            " expected result: %d, actual" +
                            " result: %d",
                    Arrays.toString(input),
                    expectedResult,
                    actualResult));
        }
    }
}
