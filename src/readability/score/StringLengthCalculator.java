package readability.score;

public class StringLengthCalculator implements ScoreCalculator {

    final private int limit;

    public StringLengthCalculator(int limit) {
        this.limit = limit;
    }

    public Level calculate(String text) {
        if (text.length() > limit) {
            return Level.HARD;
        }

        return Level.EASY;
    }
}
