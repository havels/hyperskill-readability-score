package readability;

import readability.score.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String inputFile(String[] args) throws IOException {
        if (args.length >= 1) {
            File input = new File(args[0]);
            if (input.exists() && input.isFile()) {
                StringBuilder builder = new StringBuilder();
                try (Scanner fileScanner = new Scanner(new FileInputStream(input))) {
                    while (fileScanner.hasNextLine()) {
                        builder.append(fileScanner.nextLine());
                        builder.append("\n");
                    }
                }
                return builder.toString();
            }
        }

        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        String text;
        try {
            text = inputFile(args);
        } catch (FileNotFoundException e) {
            System.out.println("Error: missing filename argument or file not found");
            return;
        } catch (IOException e) {
            System.out.println("Error: IO exception");
            return;
        }

        Statistics statistics = new Statistics(text);
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println(statistics.getStats());

        String command;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
            command = scanner.next().toUpperCase();

        } while (! command.matches("ARI|FK|SMOG|CL|ALL"));

        Score score = new Score(statistics);

        System.out.println();
        System.out.println(score.calculate(command));
        System.out.println();
        System.out.printf("This text should be understood in average %s.\n", ScoreLevel.matchLevel(score.getAverage()).getMessage());
    }
}
