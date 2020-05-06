package readability;

import readability.score.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Score scoreCalculator = new Score();
        scoreCalculator.setCalculator(new ARICalculator());

        Statistics result = new Statistics();
        try {
            File file = new File(args[0]);
            result = scoreCalculator.calculate(file);
        } catch (IOException e) {
            System.out.println("Error: IO exception");
        }

        System.out.println("The text is:");
        System.out.println(result.fullText);
        System.out.println(result.getStats());
    }
}
