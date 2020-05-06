package readability;

import readability.score.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Score scoreCalculator = new Score();
        scoreCalculator.setCalculator(new SentenceAverageCalculator(10));

        Level result = scoreCalculator.calculate(text);

        System.out.println(result.name());
    }
}
