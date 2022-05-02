package study;

import classes.ThreeRandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramTest {

    @Test
    @DisplayName("서로 다른 수로 이루어진 3자리의 수 만들기")
    void generateThreeNumberArray() throws Exception {

        ThreeRandomNumbers threeRandomNumbers = new ThreeRandomNumbers(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        threeRandomNumbers.generate();
        List<Integer> opponentNumberList = threeRandomNumbers.list();
//        System.out.println("opponentNumberList = " + opponentNumberList.toString());


//        System.out.println("threeRandomNumbers.getNumberList() = " + threeRandomNumbers.getNumberList());

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
