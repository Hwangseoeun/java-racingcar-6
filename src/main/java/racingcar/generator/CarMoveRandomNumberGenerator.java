package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public int pickRandomNumber(final int minRandomNumber, final int maxRandomNumber) {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
    }
}
