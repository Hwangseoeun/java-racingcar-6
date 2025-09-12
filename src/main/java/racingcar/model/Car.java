package racingcar.model;

public class Car {

    private static final int NAME_MAX_LENGTH = 5;

    final String name;
    final int position;

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

    private void validateNameLength() {
        if(name == null || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }
}
