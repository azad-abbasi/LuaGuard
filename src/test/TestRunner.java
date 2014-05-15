package test;

/**
 * Created by WH on 5/10/2014.
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit.class);
        /*for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }*/
        System.out.println(result.wasSuccessful()?"TEST SUCCESSFULLY" : "BUG APPEAR");
    }


}
