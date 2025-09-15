package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void racingFlow() {
        final List<String> carNames = inputView.inputCarNames();

        Cars cars = saveCars(carNames);

        final long racingFrequency = inputView.inputRacingFrequency();

        outputView.outputRacingResultMessage();
        racingResult(racingFrequency, cars);

        List<Car> winners = cars.judgeWinner();
        outputView.outputWinner(winners);
    }

    private Cars saveCars(List<String> carNames) {
        final List<Car> carList = Car.fromNames(carNames);

        return new Cars(carList);
    }

    private void racingResult(long racingFrequency, Cars cars) {
        for(long i = 0; i < racingFrequency; i++) {
            cars.moveCars();
            outputView.outputRacingResult(cars);
        }
    }
}
