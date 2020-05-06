package readability.score;

public class ARICalculator extends ScoreCalculator {

    @Override
    public Statistics calculate(String text) {
        Statistics statistics = new Statistics();

        statistics.fullText = text;

        int sentences = this.getSentencesCount(text);
        String[] words = this.splitWords(text);
        int wordsCount = words.length;
        int charactersCount = text.replaceAll("\\s+", "").length();

        statistics.characters = charactersCount;
        statistics.words = wordsCount;
        statistics.sentences = sentences;
        statistics.score = 4.71 * ((double) charactersCount / wordsCount) + .5 * ((double) wordsCount / sentences) - 21.43;

        statistics.level = Level.match(statistics.score);

        return statistics;
    }
}
