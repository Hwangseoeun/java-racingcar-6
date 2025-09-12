package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public class RacingService {

    public void saveCarNames(List<String> carNames) {
        for(String carName : carNames) {
            new Car(carName);
        }
    }
}
