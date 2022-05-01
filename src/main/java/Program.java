import classes.ScoreBoard;
import classes.ThreeRandomNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ThreeRandomNumbers threeRandomNumbers = new ThreeRandomNumbers();
        threeRandomNumbers.generate();

        while (true) {

            System.out.print("숫자를 입력해 주세요 : ");

            String[] guessNumbers = scanner.nextLine().split("");
            List<Integer> challengerNumbers = integerList(guessNumbers);

            List<Integer> computerNumbers = threeRandomNumbers.list();
            ScoreBoard scoreBoard = new ScoreBoard(computerNumbers, challengerNumbers);
            scoreBoard.compare();
            System.out.println(scoreBoard);
            if (scoreBoard.gameOver()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String go = scanner.nextLine();
                if (Integer.parseInt(go) == 2) {
                    break;
                }
                threeRandomNumbers.generate();
            }
        }

    }

    private static List<Integer> integerList(String[] guessNumbers) {
        List<Integer> challengerNumbers = new ArrayList<>();
        for (String guessNumber : guessNumbers) {
            challengerNumbers.add(Integer.parseInt(guessNumber));
        }
        return challengerNumbers;
    }
}
