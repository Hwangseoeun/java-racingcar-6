package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @DisplayName("경주할 자동차의 이름을 입력받는다.")
    @Test
    void inputCarNames() {
        //given
        final String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        String carNames = carService.inputCarNames();

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
        List<Car> cars = carService.parseCarNamesToArray(input);

        //then
        assertThat(cars).extracting(Car::getCarName)
                .containsExactlyInAnyOrder("pobi","woni","jun");
    }
}