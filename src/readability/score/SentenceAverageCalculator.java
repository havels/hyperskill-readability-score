package readability.score;

public class SentenceAverageCalculator extends ScoreCalculator {

    final private int limit;

    public SentenceAverageCalculator(int limit) {
        this.limit = limit;
    }

    @Override
    public Statistics calculate(String text) {
        Statistics statistics = new Statistics();
        String[] sentences = splitSentences(text);

        double sum = 0;

        for (String sentence : sentences) {
            sum += getWordsCount(sentence);
        }

        double average = sum / sentences.length;

        if (average > limit) {
            statistics.level = Level.HARD;
        } else {
            statistics.level = Level.EASY;
        }

        return statistics;
    }
}
