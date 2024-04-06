package baseball;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        if (strike + ball > 3) {
            throw new IllegalStateException();
        }
        this.strike = strike;
        this.ball = ball;
    }

    public Result getResult() {
        if (strike == 3) {
            return Result.GAME_OVER;
        }

        if (strike == 0 && ball == 0) {
            return Result.NOTHING;
        }

        return Result.IN_PROGRESS;
    }
}
