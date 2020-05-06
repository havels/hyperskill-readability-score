package readability.score;

public enum Level {
    EASY(-1, "EASY"),
    HARD(-1, "HARD"),
    KINDERGARTEN(1, "This text should be understood by 5-6 year olds."),
    SECOND_GRADE(2, "This text should be understood by 6-7 year olds."),
    THIRD_GRADE(3, "This text should be understood by 7-9 year olds."),
    FOURTH_GRADE(4, "This text should be understood by 9-10 year olds."),
    FIFTH_GRADE(5, "This text should be understood by 10-11 year olds."),
    SIXTH_GRADE(6, "This text should be understood by 11-12 year olds."),
    SEVENTH_GRADE(7, "This text should be understood by 12-13 year olds."),
    EIGHTH_GRADE(8, "This text should be understood by 13-14 year olds."),
    NINTH_GRADE(9, "This text should be understood by 14-15 year olds."),
    TENTH_GRADE(10, "This text should be understood by 15-16 year olds."),
    ELEVENTH_GRADE(11, "This text should be understood by 16-17 year olds."),
    TWELFTH_GRADE(12, "This text should be understood by 17-18 year olds."),
    STUDENT(13, "This text should be understood by 18-24 year olds."),
    PROFESSOR(14, "This text should be understood by 24+ year olds.");

    final private int score;

    final private String message;

    Level(int score, String message) {
        this.score = score;
        this.message = message;
    }

    public int getScore() {
        return score;
    }

    public String getMessage() {
        return message;
    }

    public static Level match(double score) {
        int intScore = (int) Math.round(score);
        Level current = null;
        for (Level level : Level.values()) {
            if (level.getScore() < 1) {
                continue;
            }
            if (level.getScore() > intScore) {
                break;
            }
            current = level;
        }

        return current;
    }
}
