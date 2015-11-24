package com.ce;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by farhansyed on 11/23/15.
 */

public class TestCases {

    @DataProvider(name = "PositiveScenariosStringToInt")
    public Object[][] positiveScenarioStringToInt() {
        return new Object[][]{
                {"98678", 98678},
                {"1", 1},
                {"0", 0},
                {"-1", -1},
                {"-98678", -98678}
        };
    }

    @Test(dataProvider = "PositiveScenariosStringToInt")
    public void testStringToInteger(String inputValue, int expectedValue) {
        Assert.assertEquals(StringUtil.stringToInteger(inputValue), expectedValue);
    }

    @DataProvider(name = "NegativeScenariosStringToInt")
    public Object[][] negativeScenarioStringToInt() {
        return new Object[][]{
                {"abcd", "Invalid character in input"},
                {"12a34", "Invalid character in input"},
                {"", "Input value can not be null or empty"},
                {null, "Input value can not be null or empty"}
        };
    }

    @Test(dataProvider = "PositiveScNegativeScenariosStringToIntenariosStringToInt")
    public void testStringToInteger(String inputValue, String expectedError) {
        try {
            StringUtil.stringToInteger(inputValue);
        } catch (NumberFormatException nfe) {
            Assert.assertTrue(nfe.getMessage().contains(expectedError));
            return;
        }

        Assert.fail("Failed scenario -> " + inputValue);
    }
}