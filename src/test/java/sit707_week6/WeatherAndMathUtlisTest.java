package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for the WeatherAndMathUtils class, designed to cover various
 * scenarios including correct data, boundary conditions, and error conditions,
 * following the Right-BICEP principles.
 */
public class WeatherAndMathUtlisTest {

    // --- Original tests from task6_1P project (corrected) ---
    @Test
    public void testStudentIdentity() {
        String studentId = "S224244945"; // Provide your actual student ID
        System.out.println("Running testStudentIdentity...");
        Assert.assertNotNull("Student ID is null", studentId);
        Assert.assertFalse("Student ID is empty", studentId.isEmpty());
        System.out.println("testStudentIdentity: PASSED\n");
    }

    @Test
    public void testStudentName() {
        String studentName = "Vansh Kumar"; // Provide your actual student name
        System.out.println("Running testStudentName...");
        Assert.assertNotNull("Student name is null", studentName);
        Assert.assertFalse("Student name is empty", studentName.isEmpty());
        System.out.println("testStudentName: PASSED\n");
    }

    // --- Tests for weatherAdvice() function ---

    /**
     * Test case for the "ALL CLEAR" advice.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testWeatherAdvice_AllClear() {
        System.out.println("Running testWeatherAdvice_AllClear...");
        // Both wind speed and precipitation are well below concerning thresholds
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 3.0));
        System.out.println("testWeatherAdvice_AllClear: PASSED\n");
    }

    /**
     * Test case for "WARN" advice due to wind speed exceeding concerning threshold.
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testWeatherAdvice_Warn_WindSpeed() {
        System.out.println("Running testWeatherAdvice_Warn_WindSpeed...");
        // Wind speed is above CONCERNING_WINDSPEED (45.0) but below DANGEROUS_WINDSPEED (70.0)
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 3.0));
        System.out.println("testWeatherAdvice_Warn_WindSpeed: PASSED\n");
    }

    /**
     * Test case for "WARN" advice due to rainfall exceeding concerning threshold.
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testWeatherAdvice_Warn_Rainfall() {
        System.out.println("Running testWeatherAdvice_Warn_Rainfall...");
        // Precipitation is above CONCERNING_RAINFALL (4.0) but below DANGEROUS_RAINFALL (6.0)
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 5.0));
        System.out.println("testWeatherAdvice_Warn_Rainfall: PASSED\n");
    }

    /**
     * Test case for "CANCEL" advice due to wind speed exceeding dangerous threshold.
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testWeatherAdvice_Cancel_WindSpeed() {
        System.out.println("Running testWeatherAdvice_Cancel_WindSpeed...");
        // Wind speed is above DANGEROUS_WINDSPEED (70.0)
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(80.0, 3.0));
        System.out.println("testWeatherAdvice_Cancel_WindSpeed: PASSED\n");
    }

    /**
     * Test case for "CANCEL" advice due to rainfall exceeding dangerous threshold.
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testWeatherAdvice_Cancel_Rainfall() {
        System.out.println("Running testWeatherAdvice_Cancel_Rainfall...");
        // Precipitation is above DANGEROUS_RAINFALL (6.0)
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(20.0, 7.0));
        System.out.println("testWeatherAdvice_Cancel_Rainfall: PASSED\n");
    }

    /**
     * Test case for "CANCEL" advice when both wind speed and rainfall are concerning.
     * Applies Boundary Conditions (B) and Correct Data (C) principle.
     */
    @Test
    public void testWeatherAdvice_Cancel_Both() {
        System.out.println("Running testWeatherAdvice_Cancel_Both...");
        // Both wind speed and precipitation are above their respective concerning thresholds
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(60.0, 5.0));
        System.out.println("testWeatherAdvice_Cancel_Both: PASSED\n");
    }

    /**
     * Test case for invalid input (negative wind speed).
     * Applies Error Conditions (E) principle, expecting an IllegalArgumentException.
     * Uses try-catch to ensure coverage of the "PASSED" message.
     */
    @Test
    public void testWeatherAdvice_InvalidInput_NegativeWindSpeed() {
        System.out.println("Running testWeatherAdvice_InvalidInput_NegativeWindSpeed...");
        try {
            WeatherAndMathUtils.weatherAdvice(-10.0, 5.0);
            // If the above line does NOT throw an exception, the test should fail
            Assert.fail("Expected IllegalArgumentException for negative wind speed, but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, so the test passes
            Assert.assertEquals("Wind speed and precipitation must be non-negative.", e.getMessage());
            System.out.println("testWeatherAdvice_InvalidInput_NegativeWindSpeed: PASSED (Expected Exception)\n");
        }
    }

    /**
     * Test case for invalid input (negative rainfall).
     * Applies Error Conditions (E) principle, expecting an IllegalArgumentException.
     * Uses try-catch to ensure coverage of the "PASSED" message.
     */
    @Test
    public void testWeatherAdvice_InvalidInput_NegativeRainfall() {
        System.out.println("Running testWeatherAdvice_InvalidInput_NegativeRainfall...");
        try {
            WeatherAndMathUtils.weatherAdvice(10.0, -5.0);
            // If the above line does NOT throw an exception, the test should fail
            Assert.fail("Expected IllegalArgumentException for negative rainfall, but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, so the test passes
            Assert.assertEquals("Wind speed and precipitation must be non-negative.", e.getMessage());
            System.out.println("testWeatherAdvice_InvalidInput_NegativeRainfall: PASSED (Expected Exception)\n");
        }
    }

    // --- Tests for isEven() function ---

    /**
     * Test case for a positive even number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsEven_Even() {
        System.out.println("Running testIsEven_Even...");
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
        System.out.println("testIsEven_Even: PASSED\n");
    }

    /**
     * Test case for a positive odd number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsEven_Odd() {
        System.out.println("Running testIsEven_Odd...");
        Assert.assertFalse(WeatherAndMathUtils.isEven(7));
        System.out.println("testIsEven_Odd: PASSED\n");
    }

    /**
     * Test case for zero (which is considered even).
     * Applies Boundary Conditions (B) principle.
     */
    @Test
     public void testIsEven_Zero() {
        System.out.println("Running testIsEven_Zero...");
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
        System.out.println("testIsEven_Zero: PASSED\n");
    }

    /**
     * Test case for a negative even number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsEven_NegativeEven() {
        System.out.println("Running testIsEven_NegativeEven...");
        Assert.assertTrue(WeatherAndMathUtils.isEven(-6));
        System.out.println("testIsEven_NegativeEven: PASSED\n");
    }

    /**
     * Test case for a negative odd number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsEven_NegativeOdd() {
        System.out.println("Running testIsEven_NegativeOdd...");
        Assert.assertFalse(WeatherAndMathUtils.isEven(-5));
        System.out.println("testIsEven_NegativeOdd: PASSED\n");
    }

    // --- Tests for isPrime() function ---

    /**
     * Test case for a prime number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsPrime_Prime() {
        System.out.println("Running testIsPrime_Prime...");
        Assert.assertTrue(WeatherAndMathUtils.isPrime(13));
        System.out.println("testIsPrime_Prime: PASSED\n");
    }

    /**
     * Test case for a non-prime number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsPrime_NotPrime() {
        System.out.println("Running testIsPrime_NotPrime...");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(10));
        System.out.println("testIsPrime_NotPrime: PASSED\n");
    }

    /**
     * Test case for the number 1 (which is not prime).
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testIsPrime_One() {
        System.out.println("Running testIsPrime_One...");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        System.out.println("testIsPrime_One: PASSED\n");
    }

    /**
     * Test case for the number 2 (the only even prime number).
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testIsPrime_Two() {
        System.out.println("Running testIsPrime_Two...");
         Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
        System.out.println("testIsPrime_Two: PASSED\n");
    }

    /**
     * Test case for a negative number (which is not prime).
     * Applies Boundary Conditions (B) principle.
     */
    @Test
    public void testIsPrime_Negative() {
        System.out.println("Running testIsPrime_Negative...");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
        System.out.println("testIsPrime_Negative: PASSED\n");
    }

    /**
     * Test case for a larger prime number.
     * Applies Correct Data (C) principle.
     */
    @Test
    public void testIsPrime_LargePrime() {
        System.out.println("Running testIsPrime_LargePrime...");
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7919));
        System.out.println("testIsPrime_LargePrime: PASSED\n");
    }

    /**
     * Test case for a larger non-prime number.
     * Applies Correct Data (C) principle.
     */
    @Test
     public void testIsPrime_LargeNotPrime() {
        System.out.println("Running testIsPrime_LargeNotPrime...");
        Assert.assertFalse(WeatherAndMathUtils.isPrime(7920));
        System.out.println("testIsPrime_LargeNotPrime: PASSED\n");
    }
}
