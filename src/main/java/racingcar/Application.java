package racingcar;

public class Application {
    public static void main(String[] args) {
        final RacingService racingService = new RacingService();

        final RacingController racingController = new RacingController(racingService);

        racingController.start();
    }
}