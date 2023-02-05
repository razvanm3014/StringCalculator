package stringcalculator;

import java.util.Arrays;
import java.util.List;


public class CalculatorUtils {
    static final String EMPTY_STRING = "";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER_START_PATTERN = "//";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String DOUBLE_DEFAULT_DELIMITER = ",,";
    private static final String DELIMITER_FIRST_CHARACTER_PATTERN = "[";
    private static final String DELIMITER_LAST_CHARACTER_PATTERN = "]";
    private static final String DELIMITERS_SPLITTER_REGEX = "\\]\\[";
    private static final String DELIMITERS_SPLITTER = "][";

    static String getAllDelimitersFromString(String inputString) {
        String delimiter = "";

        if (inputString.contains(DELIMITER_START_PATTERN)) {
            delimiter = inputString.split(NEW_LINE)[0].replace(DELIMITER_START_PATTERN, "");
        }

        return delimiter;
    }

    static List<Integer> getNumbers(String inputString, String delimiters) {
        if (EMPTY_STRING.equals(inputString)) {
            return List.of(0);
        }

        final List<String> delimiterList = getDelimiterList(delimiters);

        final String delimiterAndPattern = DELIMITER_START_PATTERN + delimiters;

        String inputStringWithoutAllDelimiters = inputString.replace(delimiterAndPattern, "");

        for (String delimiter : delimiterList) {
            inputStringWithoutAllDelimiters = inputStringWithoutAllDelimiters.replace(delimiter, DEFAULT_DELIMITER);
        }

        inputStringWithoutAllDelimiters = inputStringWithoutAllDelimiters.replace(NEW_LINE, DEFAULT_DELIMITER);

        //when we have new line and delimiter
        inputStringWithoutAllDelimiters = inputStringWithoutAllDelimiters.replace(DOUBLE_DEFAULT_DELIMITER, DEFAULT_DELIMITER);

        if (inputStringWithoutAllDelimiters.startsWith(DEFAULT_DELIMITER)) {
            inputStringWithoutAllDelimiters = inputStringWithoutAllDelimiters.replaceFirst(DEFAULT_DELIMITER, "");
        }

        final List<String> stringNumbers = Arrays.asList(inputStringWithoutAllDelimiters.split(DEFAULT_DELIMITER));

        return stringNumbers.stream().map(stringNumber -> Integer.parseInt(stringNumber.trim())).toList();
    }

    static List<String> getDelimiterList(String delimiters) {

        if (delimiters.length() == 0) {
            return List.of(DEFAULT_DELIMITER);
        }

        if (delimiters.startsWith(DELIMITER_FIRST_CHARACTER_PATTERN)) {
            delimiters = delimiters.substring(1);
        }

        if (delimiters.endsWith(DELIMITER_LAST_CHARACTER_PATTERN)) {
            delimiters = delimiters.substring(0, delimiters.length() - 1);
        }

        return delimiters.contains(DELIMITERS_SPLITTER) ? Arrays.asList(delimiters.split(DELIMITERS_SPLITTER_REGEX)) : List.of(delimiters);
    }
}
