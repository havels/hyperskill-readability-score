package readability.score;

public class ARIScore implements ScoreCalculator {

    @Override
    public double calculate(Statistics statistics) {
        int charactersCount = statistics.characters;
        int wordsCount = statistics.words;
        int sentences = statistics.sentences;

        return  4.71 * ((double) charactersCount / wordsCount) + .5 * ((double) wordsCount / sentences) - 21.43;
    }

    @Override
    public String getName() {
        return "Automated Readability Index";
    }
}