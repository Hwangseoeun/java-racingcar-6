package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingService {

    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
    }

    public List<Car> parseCarNamesToArray(String carNames){
        List<Car> cars = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carNames, ",");

        while(st.hasMoreTokens()) {
            cars.add(new Car(st.nextToken().trim()));
        }

        return cars;
    }

    public Integer inputNumberOfTries(){
        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    public Integer selectRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean judgeRandomNumberSize(){
        if(selectRandomNumber().compareTo(4)<0){
            return false;
        }

        return true;
    }
}
