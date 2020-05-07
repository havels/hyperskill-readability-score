package readability.score;

public class Score {

    final private Statistics statistics;

    public Score(Statistics statistics) {
        this.statistics = statistics;
    }

    private double scoresSum = 0.0;

    private int scoresCount = 0;

    public double getAverage() {
        return scoresSum / scoresCount;
    }

    public String calculate(String method) {
        ScoreCalculator calculator;
        String name;
        double score;
        ScoreLevel level;
        switch (method.toUpperCase()) {
            case "ARI":
                calculator = new ARIScore();
                break;
            case "FK":
                calculator = new FleschKincaidScore();
                break;
            case "SMOG":
                calculator = new SMOGScore();
                break;
            case "CL":
                calculator = new ColemanLiauScore();
                break;
            default:
                return  calculate("ARI") +
                        calculate("FK") +
                        calculate("SMOG") +
                        calculate("CL");
        }

        name = calculator.getName();
        score = calculator.calculate(statistics);
        level = ScoreLevel.matchLevel(score);

        this.scoresCount++;
        this.scoresSum += score;

        return String.format("%s: %.2f (%s).\n", name, score, level.getMessage());
    }
}
