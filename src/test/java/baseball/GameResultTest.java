package baseball;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.Result.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @DisplayName("스트라이크가 3개인 경우 게임 종료")
    @Test
    void game_over_when_strike_is_three() {
        assertGameResult(3, 0, GAME_OVER);
    }

    @DisplayName("스트라이크와 볼 개수 별 결과 메시지")
    @ParameterizedTest
    @CsvSource({
            "3,0,3스트라이크",
            "0,3,3볼",
            "0,0,낫싱",
            "2,1,1볼 2스트라이크",
            "1,2,2볼 1스트라이크"
    })
    void result_message_test(int strike, int ball, String expectedMessage) {
        assertResultMessage(strike, ball, expectedMessage);
    }

    @DisplayName("스크라이크와 볼이 전부 0인 경우 낫싱")
    @Test
    void nothing_when_strike_is_zero_and_ball_is_zero() {
        assertGameResult(0, 0, NOTHING);
    }

    @DisplayName("스트라이크가 3개 미만이고 볼이 1개 이상인 경우 계속 진행")
    @Test
    void in_progress_when_strike_is_not_three() {
        assertGameResult(1, 2, IN_PROGRESS);
        assertGameResult(2, 1, IN_PROGRESS);
        assertGameResult(0, 3, IN_PROGRESS);
    }

    @DisplayName("스크라이크와 볼 갯수를 합한 값이 3 초과인 경우 예외")
    @Test
    void exception_when_strike_plus_ball_is_greater_than_three() {
        assertThrowGameResult(4, 0);
        assertThrowGameResult(0, 4);
        assertThrowGameResult(2, 2);
    }

    private void assertGameResult(int strike, int ball, Result result) {
        //given
        GameResult sut = new GameResult(strike, ball);

        //when
        Result actual = sut.getResult();

        //then
        assertThat(actual).isEqualTo(result);
    }

    private void assertThrowGameResult(int strike, int ball) {
        //given
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new GameResult(strike, ball);

        //when - then
        Assertions.assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalStateException.class);
    }

    private void assertResultMessage(int strike, int ball, String resultMessage) {
        //given
        GameResult sut = new GameResult(strike, ball);

        //when
        String actual = sut.getResultMessage();

        //then
        assertThat(actual).isEqualTo(resultMessage);
    }

}