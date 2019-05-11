package multithread.m0.e2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaxRunnableTests {

    @DataProvider
    public Object[][] data(){
        final int[] test1 = {1, 2, 3};
        final int[] test2 = {4, 5, 6};
        final int[] test3 = {4, -5, 2, 4};
        return new Object[][]{
                {test1, 3},
                {test2, 6},
                {test3, 4}
        };
    }

    @Test(dataProvider = "data")
    public void validateMaxThreadTest(final int[] input,
                                  final int expectedResult) {
        final MaxRunnable maxR = new MaxRunnable(input);
        final Thread t = new Thread(maxR);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int actualResult = maxR.getResult();
        Assert.assertEquals(actualResult, expectedResult,
                String.format("MaxRunnable found" +
                        " incorrect max for the input: %s," +
                        " expected result: %d, actual" +
                        " result: %d",
                Arrays.toString(input),
                expectedResult,
                actualResult));
    }
}
