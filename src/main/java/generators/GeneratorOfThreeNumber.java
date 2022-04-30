package generators;

import java.util.*;

public class GeneratorOfThreeNumber {

    public static List<Integer> generate() {
        Integer[] range = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(range));

        Random random = new Random();

        ArrayList<Integer> opponentNumberList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(range.length - i);
            opponentNumberList.add(linkedList.get(index));
            linkedList.remove(index);
        }

        return opponentNumberList;
    }
}
