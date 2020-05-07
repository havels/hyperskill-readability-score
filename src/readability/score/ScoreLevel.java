package readability.score;

public enum ScoreLevel {
    KINDERGARTEN(1, "about 6 year olds"),
    SECOND_GRADE(2, "about 7 year olds"),
    THIRD_GRADE(3, "about 9 year olds"),
    FOURTH_GRADE(4, "about 10 year olds"),
    FIFTH_GRADE(5, "about 11 year olds"),
    SIXTH_GRADE(6, "about 12 year olds"),
    SEVENTH_GRADE(7, "about 13 year olds"),
    EIGHTH_GRADE(8, "about 14 year olds"),
    NINTH_GRADE(9, "about 15 year olds"),
    TENTH_GRADE(10, "about 16 year olds"),
    ELEVENTH_GRADE(11, "about 17 year olds"),
    TWELFTH_GRADE(12, "about 18 year olds"),
    STUDENT(13, "about 24 year olds"),
    PROFESSOR(14, "about 24+ year olds");

    final private int score;

    final private String message;

    ScoreLevel(int score, String message) {
        this.score = score;
        this.message = message;
    }

    public int getScore() {
        return score;
    }

    public String getMessage() {
        return message;
    }

    public static ScoreLevel matchLevel(double score) {
        int intScore = (int) Math.round(score);
        ScoreLevel current = KINDERGARTEN;
        for (ScoreLevel level : ScoreLevel.values()) {
            if (level.getScore() > intScore) {
                break;
            }
            current = level;
        }

        return current;
    }
}
