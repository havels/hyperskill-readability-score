package readability.score;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

abstract class ScoreCalculator {

    protected int getSentencesCount(String text) {
        return this.splitSentences(text).length;
    }

    protected String[] splitSentences(String text) {
        return text.split("[\\.\\?\\!]+\\s*");
    }

    protected String[] splitWords(String sentence) {
        return sentence.split("\\s+");
    }

    protected int getWordsCount(String sentence) {
        return this.splitWords(sentence).length;
    }

    abstract public Statistics calculate(String text);
}
