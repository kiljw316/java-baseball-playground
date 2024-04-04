package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("수식을 입력하면 결과값을 얻는다.")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2 = 10",
            "4 / 2 * 2 + 3 = 7"
    }, delimiter = '=')
    void success_calculate(String expression, int answer) {
        //given
        Calculator sut = new Calculator();

        //when
        int result = sut.calculate(expression);

        //then
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void zero_division_is_exception() {
        //given
        Calculator sut = new Calculator();
        String expression = "2 / 0 = 0";

        //when - then
        Assertions.assertThatThrownBy(() -> sut.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}