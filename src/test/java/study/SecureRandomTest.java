package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class SecureRandomTest {

    @DisplayName("1에서 9까지 세 개의 난수 생성")
    @Test
    void generate_three_random_number_from_one_to_nine() {
        //given
        SecureRandom secureRandom = new SecureRandom();

        //when
        int[] randomNumbers = secureRandom.ints(3, 1, 10)
                .toArray();

        //then
        assertThat(randomNumbers).hasSize(3);
        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
}
