package baseball;

import java.util.Scanner;

import static java.util.Arrays.*;

public class Client {

    public static void main(String[] args) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        BaseballGame game = new BaseballGame(numberGenerator);

        Scanner scanner = new Scanner(System.in);

        game.start();

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");

            int[] guessNumbers = getUserGuessNumbers(scanner.nextLine());

            GameResult gameResult = game.getGameResult(guessNumbers);

            System.out.println(gameResult.getResultMessage());

            if (!gameResult.isGameOver()) {
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int command = scanner.nextInt();
            if (command == 2) {
                return;
            }

            game.start();
            scanner.nextLine();
        }
    }

    private static int[] getUserGuessNumbers(String userInput) {
        return stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
