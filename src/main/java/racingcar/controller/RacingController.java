package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void racingFlow() {
        final List<String> carNames = inputView.inputCarNames();

        final List<Car> cars = racingService.saveCars(carNames);

        final long racingFrequency = inputView.inputRacingFrequency();

        outputView.outputRacingResultMessage();

        for(long i = 0; i < racingFrequency; i++) {
            racingService.moveCars(cars);
            outputView.outputRacingResult(cars);
        }


    }
}
