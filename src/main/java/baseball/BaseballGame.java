package baseball;

public class BaseballGame {

    private final RandomNumberGenerator randomNumberGenerator;
    private int[] answers;

    public BaseballGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        answers = randomNumberGenerator.generate();
    }

    public GameResult getGameResult(int[] guessNumbers) {
        int strike = countStrike(guessNumbers);
        int ball = countBall(guessNumbers);

        return new GameResult(strike, ball);
    }

    private int countStrike(int[] guessNumbers) {
        int strike = 0;
        for (int i = 0; i < answers.length; i++) {
            strike += count(answers[i], guessNumbers[i]);
        }
        return strike;
    }

    private int countBall(int[] guessNumbers) {
        int ball = 0;
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (i == j) {
                    continue;
                }
                ball += count(answers[i], guessNumbers[j]);
            }
        }
        return ball;
    }

    private int count(int answerNumber, int guessNumber) {
        if (answerNumber == guessNumber) {
            return 1;
        }
        return 0;
    }
}
