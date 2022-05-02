package classes;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerList {

    public List<Integer> list(String[] guessNumbers) {
        List<Integer> challengerNumbers = new ArrayList<>();
        for (String guessNumber : guessNumbers) {
            challengerNumbers.add(Integer.parseInt(guessNumber));
        }
        return challengerNumbers;
    }
}
