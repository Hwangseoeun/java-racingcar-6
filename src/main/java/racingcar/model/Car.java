package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    final String name;
    int position;

    public Car(final String name) {
        validateNameLength();

        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }

    private void validateNameLength() {
        if(name == null || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
    }
}
