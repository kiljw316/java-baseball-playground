package study;

import generators.GeneratorOfThreeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ProgramTest {

    @Test
    @DisplayName("서로 다른 수로 이루어진 3자리의 수 만들기")
    void generateThreeNumberArray() throws Exception {


        List<Integer> opponentNumberList = GeneratorOfThreeNumber.generate();
        HashSet<Integer> integerSet = new HashSet<>(opponentNumberList);

        assertThat(opponentNumberList.size()).isEqualTo(3);
        assertThat(integerSet.size()).isEqualTo(3);
    }

    @Test
    void randomInt() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("random = " + random.nextInt(9));
//            assertThat(random.nextInt(9) + 1).isLessThan(10);
        }
    }

    @Test
    void linkedList() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(1, 5);

        assertThat(linkedList.getFirst()).isEqualTo(1);
        assertThat(linkedList.getLast()).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(5);

        linkedList.remove(0);
        assertThat(linkedList.get(0)).isEqualTo(5);
    }

}
