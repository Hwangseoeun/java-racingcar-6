package racingcar;

import java.util.List;

public class RacingController {

    private RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void start(){
        saveCarNames();
        judgeCarMove();
    }

    public List<Car> saveCarNames(){
        return racingService.parseCarNamesToArray(racingService.inputCarNames());
    }

    public void judgeCarMove(){
        Integer tryNumber = racingService.inputNumberOfTries();

        for(int i=0; i<tryNumber; i++){
            if(racingService.decideAdvance()){
                racingService.increaseCarCount();
            }
        }
    }
}
