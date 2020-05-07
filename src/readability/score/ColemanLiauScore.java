package readability.score;

public class ColemanLiauScore implements ScoreCalculator {
    @Override
    public double calculate(Statistics statistics) {
        double sentences = statistics.sentences;
        double characters = statistics.characters;
        double words = statistics.words;
        double l = characters / words * 100;
        double s = sentences / words * 100;

        return 0.0588 * l - 0.296 * s - 15.8;
    }

    @Override
    public String getName() {
        return "Coleman–Liau index";
    }
}
