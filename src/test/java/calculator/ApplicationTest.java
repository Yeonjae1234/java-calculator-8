package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    CalculatorView view = new CalculatorView();
    CalculatorModel model = new CalculatorModel();
    CalculatorController controller = new CalculatorController(view, model);

    @Test
    void getUserInput(){
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(view.getUserInput()).isEqualTo("1,2:3");
        });
    }

    @Test
    void hasCustomDelimiter(){

        // false
        assertSimpleTest(() -> {
            model.setUserInput("1,2:3");
            assertThat(model.hasCustomDelimiter()).isEqualTo(false);
        });

        // true
        assertSimpleTest(() -> {
            model.setUserInput("//;\\n1");
            assertThat(model.hasCustomDelimiter()).isEqualTo(true);

        });
    }

    @Test
    void findCustomDelimiter(){
        assertSimpleTest(() -> {
            model.setUserInput("//;\\n1");
            model.findCustomDelimiter();
            assertThat(model.getUserInputForTest()).isEqualTo("1");
        });
    }

    @Test
    void isRegexPattern(){
        assertSimpleTest(() -> {
            assertThat(model.isRegexPattern("\\n")).isEqualTo(true);
        });
    }

//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("-1,2,3"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
