package calculator;

public class CalculatorModel {

    public boolean hasCustomDelimiter(String userInput) {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            return true;
        }
        return false;
    }

}
