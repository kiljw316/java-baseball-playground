package classes;

import java.util.List;
import java.util.Scanner;

public class BaseBallGame implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final StringToIntegerList stringToIntegerList = new StringToIntegerList();

    private final ThreeRandomNumbers threeRandomNumbers = new ThreeRandomNumbers(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});


    @Override
    public void start() {

        threeRandomNumbers.generate();
        boolean isContinue = true;

        while (isContinue) {

            System.out.print("숫자를 입력해 주세요 : ");

            List<Integer> challengerNumbers = stringToIntegerList.list(
                    scanner.nextLine()
                            .split("")
            );
            List<Integer> computerNumbers = threeRandomNumbers.list();

            ScoreBoard scoreBoard = new ScoreBoard(computerNumbers, challengerNumbers);
            scoreBoard.compare();
            System.out.println(scoreBoard);

            isContinue = resetIfGameOverFalse(scoreBoard.gameOver());
        }
    }

    private boolean resetIfGameOverFalse(boolean gameOver) {
        if (!gameOver) {
            return true;
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int go = Integer.parseInt(scanner.nextLine());
        if (go == 2) return false;

        threeRandomNumbers.generate();
        return true;
    }
}
