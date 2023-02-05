package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    public static StringCalculator stringCalculator = new StringCalculator();

    @Test
    void addMethodWhenInputContainsEmptyStringTest() {
        final Integer expectedSum = 0;
        final Integer sum = stringCalculator.add("");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }

    @Test
    void addMethodWhenInputContainsThreeNumbersTest() {
        final Integer expectedSum = 3;
        final Integer sum = stringCalculator.add("0,1,2");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }

    @Test
    void addMethodWhenInputContainsNewLineTest() {
        final Integer expectedSum = 6;
        final Integer sum = stringCalculator.add("1\n2,3");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }

    @Test
    void addMethodWhenInputStartsWithNewLineTest() {
        final Integer expectedSum = 5;
        final Integer sum = stringCalculator.add("\n2,3");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }

    @Test
    void addMethodWithDifferentDelimiterTest() {
        final Integer expectedSum = 3;
        final Integer sum = stringCalculator.add("//;\n1;2");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }

    @Test
    void addMethodWithNegativeNumbersTest() {

        assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add("2,-4,3,-5"),
                "Negatives not allowed: -4,-5");

    }

    @Test
    void addMethodWithHigherNumberTest() {
        final Integer expectedSum = 2;
        final Integer sum = stringCalculator.add("1001,2");

        assertNotNull(sum);
        assertEquals(expectedSum, sum);
    }
}
