package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingService {

    private List<Car> carList;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public List<Car> getCarList() {
        return carList;
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
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

    public void checkCarNameCharCount(String carNames) {
        if(carNames.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public Integer inputNumberOfTries() {
        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    public boolean decideAdvance() {
        Integer randomNumber = selectRandomNumber();
        return judgeRandomNumberSize(randomNumber);
    }

    public Integer selectRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean judgeRandomNumberSize(Integer number) {
        return number.compareTo(4)>=0;
    }

    public List<String> chooseRandomCars() {
        List<String> selectedCarNames = new ArrayList<>();

        for(Integer randomIndex : randomCarIndexNumbers()) {
            Car randomCar = carList.get(randomIndex);
            selectedCarNames.add(randomCar.getCarName());
        }

        return selectedCarNames;
    }

    public Integer selectRandomCarCount() {
        return Randoms.pickNumberInRange(1,carList.size());
    }

    public List<Integer> randomCarIndexNumbers() {
        Integer randomCarCount = selectRandomCarCount();

        return Randoms.pickUniqueNumbersInRange(0, carList.size()-1, randomCarCount);
    }

    public void increaseCarCount() {
        List<String> selectesdCarlist = chooseRandomCars();

        for(String name : selectesdCarlist) {
            Optional<Car> findCar = findCarByName(carList, name);
            findCar.ifPresent(Car::move);
        }
    }

    public Optional<Car> findCarByName(List<Car> carList, String name) {
        return carList.stream()
                .filter(car -> car.getCarName().equals(name))
                .findFirst();
    }

    public void printCountView() {
        for (Car car : carList) {
            String carName = car.getCarName();
            int count = car.getCount();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("-");
            }

            System.out.println(carName + " : " + sb.toString());
        }
        System.out.println();
    }

    public List<String> findWinners() {
        Integer maxCount = findMaxCount();

        if (carList == null || carList.isEmpty()) {
            throw new IllegalArgumentException("자동차의 정보가 없습니다.");
        }

        return carList.stream()
                .filter(car -> car.getCount() == maxCount)
                .map(Car::getCarName)
                .toList();
    }

    public Integer findMaxCount() {
        return carList.stream()
                .mapToInt(Car::getCount)
                .max()
                .orElse(0);
    }
}
