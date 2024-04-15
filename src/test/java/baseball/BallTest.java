package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void 같은_수가_같은_자리에_있으면_스트라이크() {
        //given
        Ball sut = new Ball(1, 1);

        //when
        BallStatus ballStatus = sut.play(new Ball(1, 1));

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 같은_수가_다른_자리에_있으면_볼() {
        //given
        Ball sut = new Ball(1, 1);

        //when
        BallStatus ballStatus = sut.play(new Ball(2, 1));

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 다른_자리_다른_수인_경우_낫싱() {
        //given
        Ball sut = new Ball(1, 1);

        //when
        BallStatus ballStatus = sut.play(new Ball(2, 2));

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
