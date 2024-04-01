package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void charAt_test() {
        String value = "abc";

        assertCharAt(value, 0, 'a');
        assertCharAt(value, 1, 'b');
        assertCharAt(value, 2, 'c');
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    void chatAt_StringIndexOutOfBoundsException_test() {
        //given
        String value = "abc";

        //when - then
        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: %s", value.length());
    }

    private void assertCharAt(String value, int index, char expected) {
        //when
        char result = value.charAt(index);

        //then
        assertThat(result).isEqualTo(expected);
    }

}
