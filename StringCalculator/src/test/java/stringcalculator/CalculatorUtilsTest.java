package stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static stringcalculator.CalculatorUtils.*;

class CalculatorUtilsTest {

    @Test
    void getAllDelimitersFromStringTest() {
        final String expectedDelimiters = "[|||]";
        final String allDelimiters = getAllDelimitersFromString("//[|||]\n1|||2|||3");

        assertNotNull(allDelimiters);
        assertEquals(expectedDelimiters, allDelimiters);
    }

    @Test
    void getNumbersTest() {
        final List<Integer> expectedNumbers = List.of(1, 2, 3);
        final String delimiters = "[|||]";
        final List<Integer> numbersArray = getNumbers("//[|||]\n1|||2|||3", delimiters);

        assertNotNull(numbersArray);
        assertEquals(expectedNumbers, numbersArray);
    }

    @Test
    void getNumbersWhenInputContainsSpaceTest() {
        final List<Integer> expectedNumbers = List.of(1, 2, 3);
        final String delimiters = "[|||]";
        final List<Integer> numbersArray = getNumbers("//[|||]\n1||| 2|||3", delimiters);

        assertNotNull(numbersArray);
        assertEquals(expectedNumbers, numbersArray);
    }

    @Test
    void getNumbersWhenInputContainsNegativeNumberTest() {
        final List<Integer> expectedNumbers = List.of(1, -2, 3);
        final String delimiters = "[|||]";
        final List<Integer> numbersArray = getNumbers("//[|||]\n1|||-2|||3", delimiters);

        assertNotNull(numbersArray);
        assertEquals(expectedNumbers, numbersArray);
    }

    @Test
    void getDelimiterFromStringTest() {
        final List<String> expectedDelimiterList = List.of("|||");
        final List<String> delimiterList = getDelimiterList("[|||]");

        assertNotNull(delimiterList);
        assertEquals(expectedDelimiterList, delimiterList);
    }

    @Test
    void getDelimitersFromStringTest() {
        final List<String> expectedDelimitersList = List.of("|", "%");
        final List<String> delimitersList = getDelimiterList("[|][%]");

        assertNotNull(delimitersList);
        assertEquals(expectedDelimitersList, delimitersList);
    }
}
