package sit707_week6;

public class WeatherAndMathUtils {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_RAINFALL = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL = 4.0;

    /**
     * Advises weather alert based on wind-speed and precipitation.
     *
     * @param windSpeed     wind speed in km/h
     * @param precipitation rainfall in mm
     * @return advice string: "CANCEL", "WARN", or "ALL CLEAR"
     */
    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException("Wind speed and precipitation must be non-negative.");
        }

        if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
                || (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
            return "CANCEL";
        } else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
            return "WARN";
        } else {
            return "ALL CLEAR";
        }
    }

    /**
     * Returns true if the input number is even.
     *
     * @param a integer input
     * @return true if even, false if odd
     */
    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    /**
     * Returns true if the input number is a prime number.
     *
     * @param n integer input
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;             // Not prime: n <= 1
        if (n == 2) return true;              // Prime: 2 is the only even prime
        if (n % 2 == 0) return false;         // Not prime: other even numbers

        // Only check odd divisors up to sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;     // Not prime: divisible by i
        }

        return true;                          // Prime: no divisors found
    }

}
