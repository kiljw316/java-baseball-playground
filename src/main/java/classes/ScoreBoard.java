package classes;

import java.util.List;

public class ScoreBoard {

    private final List<Integer> computerNumbers;
    private final List<Integer> challengerNumbers;

    private int ballCount = 0;
    private int strikeCount = 0;
    private boolean gameOver = false;

    public ScoreBoard(List<Integer> computerNumbers, List<Integer> challengerNumbers) {
        this.computerNumbers = computerNumbers;
        this.challengerNumbers = challengerNumbers;
    }

    public void compare() {
        compareNumbers(0);
        compareNumbers(1);
        compareNumbers(2);

        if (strikeCount == 3) {
            gameOver = true;
        }
    }

    public boolean gameOver() {
        return gameOver;
    }

    @Override
    public String toString() {
        String result = "";
        if (ballCount == 0 && strikeCount == 0) {
            result += "낫싱";
            return result;
        }

        if (ballCount > 0) {
            result += ballCount + "볼 ";
        }

        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }

        if (strikeCount == 3) {
            result += "\n" + strikeCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        return result;
    }

    private void compareNumbers(int index) {
        if (computerNumbers.get(index).equals(challengerNumbers.get(index))) {
            strikeCount++;
            return;
        }
        if (computerNumbers.contains(challengerNumbers.get(index))) {
            ballCount++;
        }
    }
}
