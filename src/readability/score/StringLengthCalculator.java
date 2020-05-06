package readability.score;

public class StringLengthCalculator extends ScoreCalculator {

    final private int limit;

    public StringLengthCalculator(int limit) {
        this.limit = limit;
    }

    @Override
    public Statistics calculate(String text) {
        Statistics statistics = new Statistics();
        if (text.length() > limit) {
            statistics.level = Level.HARD;
        } else {
            statistics.level = Level.EASY;
        }

        return statistics;
    }
}
