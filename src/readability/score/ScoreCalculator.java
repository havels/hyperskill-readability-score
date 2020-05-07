package readability.score;

interface ScoreCalculator {

    double calculate(Statistics statistics);

    String getName();
}
