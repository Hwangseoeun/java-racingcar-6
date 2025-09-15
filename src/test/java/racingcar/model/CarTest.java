package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private static Car createCar(String name) {
        return new Car(name);
    }

    private static Car createCar(String name, RandomNumberGenerator randomNumberGenerator) {
        return new Car(name, randomNumberGenerator);
    }

    @DisplayName("생성자에 유효한 입력값(이름)을 입력하면 Car 인스턴스가 생성된다.")
    @Test
    void createCarSuccess() {
        //Given
        final String name = "test";

        //When & Then
        assertThatCode(() -> new Car(
            name
        ))
        .doesNotThrowAnyException();
    }

    @DisplayName("유효한 인자값(자동차 이름 리스트)이 들어오면 각각의 Car 객체를 생성한 후 리스트로 반환한다.")
    @Test
    void givenCarNames_thenReturnCars() {
        //Given
        final List<String> names = List.of("A", "B", "C");

        //When
        List<Car> cars = Car.fromNames(names);

        //Then
        assertThat(cars.get(0).getName()).isEqualTo(names.get(0));
        assertThat(cars.get(1).getName()).isEqualTo(names.get(1));
        assertThat(cars.get(2).getName()).isEqualTo(names.get(2));
    }

    @DisplayName("이름으로 null이 들어오면 예외가 발생한다.")
    @Test
    void thrownExceptionWhenCarNameIsNull() {
        //Given
        final String name = null;

        //When & Then
        assertThatThrownBy(() -> createCar(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("이름 글자수가 5 초과이면 예외가 발생한다.")
    @Test
    void thrownExceptionWhenCarNameLengthIsOver() {
        //Given
        final String name = "12345678";

        //When & Then
        assertThatThrownBy(() -> createCar(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 자동차 이름입니다.");
    }

    @DisplayName("뽑은 랜덤 숫자가 4 이상이면 차의 위치가 1 증가한다.")
    @Test
    void whenRandomNumberIsOverThenPositionIncreasesByOne() {
        //Given
        final Car car = createCar("그로밋", (minRandomNumber, maxRandomNumber) -> 5);
        final int afterPosition = 1;

        //When
        car.move();

        //Then
        assertThat(car.getPosition()).isEqualTo(afterPosition);
    }

    @DisplayName("뽑은 랜덤 숫자가 4 미만이면 차의 위치가 움직이지 않는다.")
    @Test
    void whenRandomNumberIsNotOverThenPositionIsNotIncreasesByOne() {
        //Given
        final Car car = createCar("그로밋", (minRandomNumber, maxRandomNumber) -> 1);
        final int afterPosition = 0;

        //When
        car.move();

        //Then
        assertThat(car.getPosition()).isEqualTo(afterPosition);
    }
}