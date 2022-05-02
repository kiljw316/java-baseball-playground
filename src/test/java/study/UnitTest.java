package study;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {

    @Test
    void calc() throws Exception {
        String input = "2 + 3 * 4 / 2";
        InputStream inputStream = generateUserInput(input);
        Scanner scanner = new Scanner(inputStream);

        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            result = operate(result, values[i], values[i + 1]);
        }

        scanner.close();

        assertThat(result).isEqualTo(10);
    }

    private Integer operate(Integer result, String operator, String operand) {
        if (operator.equals("*")) {
            result *= Integer.parseInt(operand);
        } else if (operator.equals("/")) {
            result /= Integer.parseInt(operand);
        } else if (operator.equals("+")) {
            result += Integer.parseInt(operand);
        } else if (operator.equals("-")) {
            result -= Integer.parseInt(operand);
        }
        return result;
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
