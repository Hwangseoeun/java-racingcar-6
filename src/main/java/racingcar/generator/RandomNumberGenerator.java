package racingcar.generator;

public interface RandomNumberGenerator {

    int MIN_RANDOM_NUMBER = 0;
    int MAX_RANDOM_NUMBER = 9;

    int pickRandomNumber(int minRandomNumber, int maxRandomNumber);
}
