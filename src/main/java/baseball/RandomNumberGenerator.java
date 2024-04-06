package baseball;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    public int[] generate() {
        return new SecureRandom()
                .ints(3, 1, 10)
                .toArray();
    }
}
