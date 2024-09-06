package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingService racingService = new RacingService();

        racingService.saveCarNames();

        Integer numberOfTries = racingService.inputNumberOfTries();

        racingService.decideAdvance();

        racingService.chooseRandomCars();
    }
}
