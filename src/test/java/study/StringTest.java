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

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    void substring() {
        String values = "(1,2)";
        values = values.substring(1, values.length() - 1);
        assertThat(values).isEqualTo("1,2");;
    }

    @Test
    @DisplayName("charAt IndexOutOfBoundException")
    void charAt() {
        String values = "abc";
        assertThat(values.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> values.charAt(values.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
