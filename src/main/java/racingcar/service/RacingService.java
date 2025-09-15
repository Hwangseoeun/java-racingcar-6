package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public List<Car> saveCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void moveCars(List<Car> cars) {
        cars.forEach(Car::move);
    }

    public List<Car> judgeWinner(List<Car> cars) {
        final int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }
}
