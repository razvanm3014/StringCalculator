package stringcalculator;

import java.util.List;

import static stringcalculator.CalculatorUtils.getAllDelimitersFromString;
import static stringcalculator.CalculatorUtils.getNumbers;

public class StringCalculator {

    static final String ERROR_MESSSAGE_PATTERN = "Negatives not allowed: %s";

    Integer add(String numbers) {
        Integer sum = 0;

        final String allDelimiters = getAllDelimitersFromString(numbers);
        final List<Integer> numbersList = getNumbers(numbers, allDelimiters);

        final List<Integer> negativeNumbers = numbersList.stream().filter(number -> number < 0).toList();

        if (negativeNumbers.isEmpty()) {
            for (Integer positiveNumber : numbersList) {
                sum += positiveNumber < 1001 ? positiveNumber : 0;
            }
        } else {
            final String errorMessage = String.format(ERROR_MESSSAGE_PATTERN, negativeNumbers);
            throw new IllegalArgumentException(errorMessage);
        }

        return sum;
    }
}
