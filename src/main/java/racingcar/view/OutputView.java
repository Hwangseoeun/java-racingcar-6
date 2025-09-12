package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final int MIN_WINNER_COUNT = 1;

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

    public void outputWinner(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        if(cars.size() > MIN_WINNER_COUNT) {
            cars.forEach(car -> System.out.print(car.getName() + ", "));
        }

        final Car winner = cars.get(0);
        System.out.println(winner.getName());
    }
}
