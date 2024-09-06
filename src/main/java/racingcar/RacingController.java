package racingcar;

import java.util.List;

public class RacingController {

    private RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void start(){
        saveCarNames();
        printResultText();
        judgeCarMove();
    }

    public List<Car> saveCarNames(){
        return racingService.parseCarNamesToArray(racingService.inputCarNames());
    }

    public void printResultText(){
        System.out.println("실행 결과");
    }

    public void judgeCarMove(){
        Integer tryNumber = racingService.inputNumberOfTries();

        for(int i=0; i<tryNumber; i++){
            if(racingService.decideAdvance()){
                racingService.increaseCarCount();
            }
            racingService.printCountView();
        }
    }
}
