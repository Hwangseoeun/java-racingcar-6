package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void outputRacingResultMessage() {
        System.out.println("실행 결과");
    }

    public void outputRacingResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + convertPositionPrintType(car));
        }
        System.out.println();
    }

    private String convertPositionPrintType(Car car) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<car.getPosition(); i++) {
            result.append("-");
        }

        return result.toString();
    }
}
