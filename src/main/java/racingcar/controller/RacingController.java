package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    private static final int MIN_RANDOM_NUMBER_TO_MOVE = 4;

    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void racingFlow() {
        final List<String> carNames = inputView.inputCarNames();

        final List<Car> cars = racingService.saveCars(carNames);

        final long racingFrequency = inputView.inputRacingFrequency();

        for(long i = 0; i < racingFrequency; i++) {
            carsMove(cars);
        }
    }

    private void carsMove(List<Car> cars) {
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
