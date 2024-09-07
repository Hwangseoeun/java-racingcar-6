package racingcar;

public class Car {
    private final String name;
    private int advanceCount;

    public Car(String name) {
        this.name = name;
        this.advanceCount = 0;
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
