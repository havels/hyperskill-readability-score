package readability.score;

public class Score {
    private ScoreCalculator calculator;

    public Score() {
        this.calculator = new StringLengthCalculator(100);
    }

    public void setCalculator(ScoreCalculator calculator) {
        this.calculator = calculator;
    }

    public Level calculate(String text) {
        return this.calculator.calculate(text);
    }
}
