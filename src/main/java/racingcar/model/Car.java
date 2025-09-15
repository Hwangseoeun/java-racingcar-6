package racingcar.model;

import racingcar.generator.CarMoveRandomNumberGenerator;
import racingcar.generator.RandomNumberGenerator;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_NUMBER_TO_MOVE = 4;

    private final RandomNumberGenerator randomNumberGenerator;

    final String name;
    int position;

    public Car(final String name) {
        validateNameLength(name);

        this.name = name;
        this.position = 0;
        this.randomNumberGenerator = new CarMoveRandomNumberGenerator();
    }

    public Car(final String name, RandomNumberGenerator randomNumberGenerator) {
        validateNameLength(name);

        this.name = name;
        this.position = 0;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void movePosition() {
        this.position++;
    }

    private void validateNameLength(String name) {
        if(name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public void move() {
        final int randomNumber = randomNumberGenerator.pickRandomNumber(RandomNumberGenerator.MIN_RANDOM_NUMBER, RandomNumberGenerator.MAX_RANDOM_NUMBER);
        judgeCarMove(randomNumber);
    }

    private void judgeCarMove(int randomNumber) {
        if(randomNumber >= MIN_RANDOM_NUMBER_TO_MOVE) {
            movePosition();
        }
    }
}
