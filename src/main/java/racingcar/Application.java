package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        RacingService racingService = new RacingService();
        RacingController racingController = new RacingController(inputView, racingService);

        racingController.racingFlow();
    }
}
