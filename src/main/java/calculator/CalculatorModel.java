package calculator;

import java.util.ArrayList;

public class CalculatorModel {

    private String userInput;
    private ArrayList<String> delimiterList;

    public CalculatorModel() {
        this.delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(";");
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean hasCustomDelimiter() {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            return true;
        }
        return false;
    }


}
