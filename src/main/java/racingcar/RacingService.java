package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingService {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> parseCarNamesToArray(String carNames) {
        carList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carNames, ",");

        while(st.hasMoreTokens()) {
            String carName = st.nextToken().trim();
            checkCarNameCharCount(carName);
            carList.add(new Car(carName));
        }

        return carList;
    }

    protected void checkCarNameCharCount(String carNames) {
        if(carNames.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public boolean decideAdvance() {
        Integer randomNumber = selectRandomNumber();
        return judgeRandomNumberSize(randomNumber);
    }

    protected Integer selectRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    protected boolean judgeRandomNumberSize(Integer number) {
        return number.compareTo(4)>=0;
    }

    public void increaseCarCount() {
        List<String> selectesdCarlist = chooseRandomCars();

        for(String name : selectesdCarlist) {
            Optional<Car> findCar = findCarByName(carList, name);
            findCar.ifPresent(Car::move);
        }
    }

    protected List<String> chooseRandomCars() {
        List<String> selectedCarNames = new ArrayList<>();

        for(Integer randomIndex : randomCarIndexNumbers()) {
            Car randomCar = carList.get(randomIndex);
            selectedCarNames.add(randomCar.getCarName());
        }

        return selectedCarNames;
    }

    protected List<Integer> randomCarIndexNumbers() {
        Integer randomCarCount = selectRandomCarCount();

        return Randoms.pickUniqueNumbersInRange(0, carList.size()-1, randomCarCount);
    }

    protected Integer selectRandomCarCount() {
        return Randoms.pickNumberInRange(1,carList.size());
    }

    protected Optional<Car> findCarByName(List<Car> carList, String name) {
        return carList.stream()
                .filter(car -> car.getCarName().equals(name))
                .findFirst();
    }

    public List<String> findWinners() {
        Integer maxCount = findMaxCount();

        if (carList == null || carList.isEmpty()) {
            throw new IllegalArgumentException("자동차의 정보가 없습니다.");
        }

        return carList.stream()
                .filter(car -> car.getAdvanceCount() == maxCount)
                .map(Car::getCarName)
                .toList();
    }

    protected Integer findMaxCount() {
        return carList.stream()
                .mapToInt(Car::getAdvanceCount)
                .max()
                .orElse(0);
    }
}
