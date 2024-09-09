package racingcar;

public class Car {
    private static final int DEFAULT_ADVANCE_COUNT = 0;
    private final String name;
    private int advanceCount;

    public Car(String name) {
        this.name = name;
        this.advanceCount = DEFAULT_ADVANCE_COUNT;
    }

    public String getCarName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void move() {
        this.advanceCount++;
    }
}
