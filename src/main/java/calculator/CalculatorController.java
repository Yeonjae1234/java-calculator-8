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
    }

}
