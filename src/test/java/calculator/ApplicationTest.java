package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    CalculatorView view = new CalculatorView();
    CalculatorModel model = new CalculatorModel();

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
            assertThat(model.hasCustomDelimiter("1,2:3")).isEqualTo(false);
        });

        // true
        assertSimpleTest(() -> {
            assertThat(model.hasCustomDelimiter("//;\\\\n1")).isEqualTo(true);

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
