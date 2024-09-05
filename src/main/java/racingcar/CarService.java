package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarService {

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
}
