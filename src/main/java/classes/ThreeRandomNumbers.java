package classes;

import java.util.*;

public class ThreeRandomNumbers {

    private List<Integer> threeRandomNumbers;

    public ThreeRandomNumbers() {
    }

    public void generate() {
        Integer[] range = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        threeRandomNumbers = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(range));
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
