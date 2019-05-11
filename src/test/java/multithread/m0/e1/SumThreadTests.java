package multithread.m0.e1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SumThreadTests {

    @DataProvider
    public Object[][] data(){
        final int[] test1 = {1, 2, 3};
        final int[] test2 = {4, 5, 6};
        return new Object[][]{
                {test1, 6},
                {test2, 15}
        };
    }

    @Test(dataProvider = "data")
    public void validateSumThreadTest(final int[] input,
                                      final int expectedResult) {
        final SumThread t = new SumThread(input);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int actualResult = t.getResult();
        Assert.assertEquals(actualResult, expectedResult,
                String.format("SumThread calculates" +
                                "incorrect sum for the input: %s," +
                                " expected result: %d, actual" +
                                " result: %d",
                        Arrays.toString(input),
                        expectedResult,
                        actualResult));
    }
}
