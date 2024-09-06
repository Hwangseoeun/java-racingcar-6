package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();

        String carNames = racingService.inputCarNames();
        List<Car> cars = racingService.parseCarNamesToArray(carNames);

        Integer numberOfTries = racingService.inputNumberOfTries();

        racingService.decideAdvance();

        racingService.chooseRandomCars();
    }
}
