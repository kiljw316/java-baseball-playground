package classes;

import java.util.*;

public class ThreeRandomNumbers {

    private List<Integer> threeRandomNumbers;
    private final Integer[] range;

    public ThreeRandomNumbers(Integer[] range) {
        this.range = range;
    }

    public void generate() {
        threeRandomNumbers = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(range));
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(range.length - i);
            threeRandomNumbers.add(linkedList.get(index));
            linkedList.remove(index);
        }
    }

    public List<Integer> list() {
        return threeRandomNumbers;
    }
}
