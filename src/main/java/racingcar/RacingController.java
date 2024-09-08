package racingcar;

import java.util.*;

public class RacingController {

    private final RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void start() {
        saveCarNames();
        printResultText();
        judgeCarMove();
        printWinnerResult();
    }

    public List<Car> saveCarNames() {
        return racingService.parseCarNamesToArray(racingService.inputCarNames());
    }

    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void judgeCarMove() {
        Integer tryNumber = racingService.inputNumberOfTries();

        for(int i=0; i<tryNumber; i++) {
            if(racingService.decideAdvance()) {
                racingService.increaseCarCount();
            }
            racingService.printCountView();
        }
    }

    public void printWinnerResult() {
        List<String> winners = racingService.findWinners();

        StringJoiner joiner = new StringJoiner(", ");

        for(String winner : winners) {
            joiner.add(winner);
        }

        System.out.print("최종 우승자 : " + joiner.toString());
    }
}
