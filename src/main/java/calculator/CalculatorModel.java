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

    String getUserInputForTest(){
        return userInput;
    }

    public boolean hasCustomDelimiter() {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            return true;
        }
        return false;
    }

    public void findCustomDelimiter(){
        while (hasCustomDelimiter()) {
            int index = userInput.indexOf("\\n");
            delimiterList.add(userInput.substring(2, index));
            userInput = userInput.substring(index + 2);
        }
    }

    public boolean isRegexPattern(String delimiter){
        char ch = 0;
        return !((delimiter.length() == 1 &&
                ".$|()[{^?*+\\".indexOf(ch = delimiter.charAt(0)) == -1) ||
                (delimiter.length() == 2 &&
                        delimiter.charAt(0) == '\\' &&
                        (((ch = delimiter.charAt(1))-'0')|('9'-ch)) < 0 &&
                        ((ch-'a')|('z'-ch)) < 0 &&
                        ((ch-'A')|('Z'-ch)) < 0));
    }

    public String makeDelimiterString(){
        StringBuilder sb = new StringBuilder();
        for (String delimiter : delimiterList) {
            if(isRegexPattern(delimiter)){
                sb.append("\\");
            }
            sb.append(delimiter).append("|");
        }
        sb.setLength(sb.length()-1);
        return String.valueOf(sb);
    }

    public String[] splitUserInput(){
        return userInput.split(makeDelimiterString());
    }

}
