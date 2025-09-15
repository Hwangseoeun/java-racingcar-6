package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private final RacingService racingService = new RacingService();

    private static Car createCar(String name) {
        return new Car(name);
    }

    @DisplayName("자동차 이름들이 입력으로 들어오면 각각의 자동차 객체가 저장된다.")
    @Test
    void givenCarNamesThenSaveCars() {
        //Given
        final List<String> carNames = List.of("A", "B", "C");
        final int carCount = 3;

        //When
        final List<Car> cars = racingService.saveCars(carNames);

        //Then
        assertThat(cars.size()).isEqualTo(carCount);
    }
}
