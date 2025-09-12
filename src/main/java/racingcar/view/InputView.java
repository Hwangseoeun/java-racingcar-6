package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<String> inputCarNames() {
        final String names = Console.readLine();

        return List.of(names.split(","));
    }
}
