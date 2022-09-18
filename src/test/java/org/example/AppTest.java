package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 59; j++) {
                String minute = j < 10 ? "0" + j : String.valueOf(j);
                String hour = i < 10 ? "0" + i : String.valueOf(i);
                System.out.println(App.timeToWord(hour + ":" + minute));
            }
        }
    }
}
