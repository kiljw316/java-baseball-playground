package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    public int getPosition() {
        return position;
    }

    public int getNum() {
        return num;
    }

    public BallStatus play(Ball another) {
        if (this.isStrike(another)) {
            return BallStatus.STRIKE;
        }

        if (this.isBall(another)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball another) {
        return (this.position != another.getPosition()) && (this.num == another.getNum());
    }

    private boolean isStrike(Ball another) {
        return this.equals(another);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, num);
    }
}
