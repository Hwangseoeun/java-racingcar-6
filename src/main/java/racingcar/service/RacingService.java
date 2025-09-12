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
}
