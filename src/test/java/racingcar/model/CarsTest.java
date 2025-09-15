package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static Car createCar(String name) {
        return new Car(name);
    }

    private static Car createCar(String name, RandomNumberGenerator randomNumberGenerator) {
        return new Car(name, randomNumberGenerator);
    }

    private static List<Car> createCars() {
        return List.of(
            createCar("A"),
            createCar("B"),
            createCar("C")
        );
    }

    @DisplayName("생성자에 유효한 입력값(Car 객체 리스트)을 입력하면 Cars 인스턴스가 생성된다.")
    @Test
    void givenCarNamesThenSaveCars() {
        //Given
        final List<Car> carList = createCars();
        final int carCount = 3;

        //When
        final Cars cars = new Cars(carList);

        //Then
        assertThat(cars.getCars().size()).isEqualTo(carCount);
    }

    @DisplayName("모든 자동차가 moveCars() 실행 시 이동 규칙에 따라 움직인다.")
    @Test
    void whenMoveCarsThenMovesAllCars() {
        // given
        final Cars cars = new Cars(List.of(
            createCar("A", (minRandomNumber, maxRandomNumber) -> 5), // 이동
            createCar("B", (minRandomNumber, maxRandomNumber) -> 2) // 정지
        ));

        // when
        cars.moveCars();

        // then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @DisplayName("position 값이 가장 큰 자동차가 반환된다.")
    @Test
    void whenJudgeWinnerThenReturnWinner() {
        // given
        final Cars cars = new Cars(List.of(
            createCar("A", (minRandomNumber, maxRandomNumber) -> 5), // 이동
            createCar("B", (minRandomNumber, maxRandomNumber) -> 2) // 정지
        ));
        cars.moveCars();

        final List<Car> winnerCar = List.of(cars.getCars().get(0));

        // when
        final List<Car> carList = cars.judgeWinner();

        // then
        assertThat(carList).isEqualTo(winnerCar);
    }

    @DisplayName("position 값이 가장 큰 자동차가 여러 대라면 모두 반환한다.")
    @Test
    void whenJudgeWinnerThenReturnWinners() {
        // given
        final Cars cars = new Cars(List.of(
            createCar("A", (minRandomNumber, maxRandomNumber) -> 5), // 이동
            createCar("B", (minRandomNumber, maxRandomNumber) -> 5),
            createCar("C", (minRandomNumber, maxRandomNumber) -> 2)
        ));
        cars.moveCars();

        final List<Car> winnerCar = List.of(
            cars.getCars().get(0),
            cars.getCars().get(1)
        );

        // when
        final List<Car> carList = cars.judgeWinner();

        // then
        assertThat(carList).isEqualTo(winnerCar);
    }
}
