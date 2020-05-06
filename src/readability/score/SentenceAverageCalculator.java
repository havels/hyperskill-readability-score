package readability.score;

public class SentenceAverageCalculator implements ScoreCalculator {

    final private int limit;

    public SentenceAverageCalculator(int limit) {
        this.limit = limit;
    }

    private String[] splitSentences(String text) {
        return text.split("[\\.\\?\\!]+\\s*");
    }

    private int getWordsCount(String sentence) {
        String[] words = sentence.split("\\W+");

        return words.length;
    }


    public Level calculate(String text) {
        String[] sentences = splitSentences(text);

        double sum = 0;

        for (String sentence : sentences) {
            sum += getWordsCount(sentence);
        }

        double average = sum / sentences.length;

        if (average > limit) {
            return Level.HARD;
        }

        return Level.EASY;
    }
}
