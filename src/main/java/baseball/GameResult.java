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

    public String getResultMessage() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball);
            sb.append("볼");
        }

        if (sb.length() != 0 && strike != 0) {
            sb.append(" ");
        }

        if (strike != 0) {
            sb.append(strike);
            sb.append("스트라이크");
        }

        return sb.toString();
    }

    public boolean isGameOver() {
        return this.getResult() == Result.GAME_OVER;
    }
}
