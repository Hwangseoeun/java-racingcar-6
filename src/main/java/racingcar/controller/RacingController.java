package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void racingStart() {
        final List<String> carNames = inputView.InputCarNames();

        racingService.saveCarNames(carNames);
    }
}
