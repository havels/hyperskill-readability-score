package readability.score;

public class Statistics {
    public String fullText = "";

    public int characters = 0;

    public int words = 0;

    public int sentences = 0;

    public double score = 0.0;

    public Level level;

    public String getStats() {
        return String.format("Words: %d\nSentences: %d\nCharacters: %d\nThe score is: %.2f\n%s",
                this.words,
                this.sentences,
                this.characters,
                this.score,
                this.level.getMessage());
    }
}
