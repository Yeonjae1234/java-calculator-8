package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorView {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public void printResult(int answer) {
        System.out.println("결과 : " + answer);
    }
}
