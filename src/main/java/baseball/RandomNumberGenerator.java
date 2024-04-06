package baseball;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_MIN_VALUE = 1;
    private static final int RANDOM_NUMBER_MAX_VALUE = 9;
    private static final int RANDOM_NUMBER_MAX_SIZE = 3;

    public int[] generate() {
        return new SecureRandom()
                .ints(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE + 1)
                .distinct()
                .limit(RANDOM_NUMBER_MAX_SIZE)
                .toArray();
    }
}
