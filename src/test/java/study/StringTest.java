package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    void split_test() {
        //given
        String value = "1,2";

        //when
        String[] result = value.split(",");

        //then
        assertThat(result).contains("1", "2");
        assertThat(result).hasSize(2);
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void single_array_split_test() {
        //given
        String value = "1";

        //when
        String[] result = value.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).hasSize(1);
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    void substring_test() {
        //given
        String value = "(1,2)";

        //when
        String result = value.substring(1, 4);

        //then
        assertThat(result).isEqualTo("1,2");
    }
}
