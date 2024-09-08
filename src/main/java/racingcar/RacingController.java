package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void start() {
        saveCarNames();
        printResultText();
        judgeCarMove();
        printWinnerResult();
    }

    public List<Car> saveCarNames() {
        return racingService.parseCarNamesToArray(inputCarNames());
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
    }

    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void judgeCarMove() {
        Integer tryNumber = inputNumberOfTries();

        for(int i=0; i<tryNumber; i++) {
            if(racingService.decideAdvance()) {
                racingService.increaseCarCount();
            }
            printCountView();
        }
    }

    public Integer inputNumberOfTries() {
        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    public void printCountView() {
        for (Car car : racingService.getCarList()) {
            String carName = car.getCarName();
            int count = car.getAdvanceCount();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("-");
            }

            System.out.println(carName + " : " + sb.toString());
        }
        System.out.println();
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
