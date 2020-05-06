package readability.score;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Score {
    private ScoreCalculator calculator;

    public Score() {
        this.calculator = new StringLengthCalculator(100);
    }

    public void setCalculator(ScoreCalculator calculator) {
        this.calculator = calculator;
    }

    public Statistics calculate(String text) {
        return this.calculator.calculate(text);
    }

    public Statistics calculate(File file) throws IOException {
        StringBuilder text = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new FileInputStream(file))) {
            while (fileScanner.hasNextLine()) {
                text.append(fileScanner.nextLine());
                text.append("\n");
            }
        }

        return this.calculate(text.toString());
    }
}
