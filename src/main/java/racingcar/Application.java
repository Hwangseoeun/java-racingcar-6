package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();

        String carNames = carService.inputCarNames();

        List<Car> cars = carService.parseCarNamesToArray(carNames);
    }
}
