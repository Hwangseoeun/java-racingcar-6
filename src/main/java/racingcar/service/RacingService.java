package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private static final int MIN_RANDOM_NUMBER_TO_MOVE = 4;

    public List<Car> saveCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void moveCars(List<Car> cars) {
        for(Car car : cars) {
            final int randomNumber = car.pickRandomNumber();
            judgeCarMove(car, randomNumber);
        }
    }

    private void judgeCarMove(Car car, int randomNumber) {
        if(randomNumber >= MIN_RANDOM_NUMBER_TO_MOVE) {
            car.movePosition();
        }
    }
}
