package calculator;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String userInput = view.getUserInput();
        model.setUserInput(userInput);
        model.findCustomDelimiter();
        String[] splitUserInput = model.splitUserInput();
        int answer = model.addString(splitUserInput);
        view.printResult(answer);
    }

}
