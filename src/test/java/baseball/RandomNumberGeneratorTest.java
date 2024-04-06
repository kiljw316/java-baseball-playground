package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class RandomNumberGeneratorTest {

    @DisplayName("서로 다른 세 개의 난수 생성")
    @Test
    void generate_distinct_three_number() {
        //given
        RandomNumberGenerator sut = new RandomNumberGenerator();

        //when
        Set<Integer> actual = Arrays.stream(sut.generate())
                .boxed()
                .collect(Collectors.toSet());

        //then
        Assertions.assertThat(actual).hasSize(3);
    }
}