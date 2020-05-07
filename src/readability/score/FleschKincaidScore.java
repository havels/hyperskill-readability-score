package readability.score;

public class FleschKincaidScore implements ScoreCalculator {

    @Override
    public double calculate(Statistics statistics) {

        int words = statistics.words;
        int sentences = statistics.sentences;
        int syllables = statistics.syllables;

        return  0.39 * ((double) words / sentences) + 11.8 * ((double) syllables / words) - 15.59;
    }

    @Override
    public String getName() {
        return "Flesch–Kincaid readability tests";
    }
}
