package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @DisplayName("경주할 자동차의 이름을 입력받는다.")
    @Test
    void inputCarNames() {
        //given
        final String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        String carNames = racingService.inputCarNames();

        //then
        assertThat(carNames).isEqualTo("pobi,woni,jun");
    }

    @DisplayName("입력받은 자동차들의 이름을 저장한다.")
    @Test
    void parseCarNamesToArray() {
        //given
        final String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        List<Car> cars = racingService.parseCarNamesToArray(input);

        //then
        assertThat(cars).extracting(Car::getCarName)
                .containsExactlyInAnyOrder("pobi","woni","jun");
    }

    @DisplayName("시도할 횟수를 입력받는다.")
    @Test
    void InputNumberOfTries() {
        //given
        final String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Integer numberOfTries = racingService.inputNumberOfTries();

        //then
        assertThat(numberOfTries).isEqualTo(5);
    }

    @DisplayName("무작위 값이 4 이상인지 판단한다.")
    @Test
    void judgeRandomNumberSize() {
        //given
        final Integer number = 5;

        //when
        Boolean judgeAdvance = racingService.judgeRandomNumberSize(number);

        //then
        assertThat(judgeAdvance).isEqualTo(true);
    }
}