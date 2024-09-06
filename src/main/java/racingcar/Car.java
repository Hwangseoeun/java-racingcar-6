package racingcar;

public class Car {
    private final String carName;
    private int count;

    public Car(String carName){
        this.carName = carName;
        this.count = 0;
    }

    public String getCarName(){
        return carName;
    }

    public int getCount(){
        return count;
    }

    public void move(){
        this.count++;
    }
}
