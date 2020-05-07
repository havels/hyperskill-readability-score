package readability.score;

public class SMOGScore implements ScoreCalculator {
    @Override
    public double calculate(Statistics statistics) {

        int polysyllables = statistics.polysyllables;
        int sentences = statistics.sentences;

        return 1.043 * Math.sqrt(polysyllables * (30.0 / sentences)) + 3.1291;
    }

    @Override
    public String getName() {
        return "Simple Measure of Gobbledygook";
    }
}
