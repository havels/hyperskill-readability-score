package readability.score;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistics {
    public String fullText;

    public int characters;

    public int words;

    public int sentences;

    public int syllables;

    public int polysyllables;

    public Statistics(String text) {
        this.fullText = text.trim();
        this.sentences = countSentences();
        this.characters = countCharacters();

        String[] words = this.fullText.split("\\s+");
        this.words = words.length;

        this.syllables = 0;
        this.polysyllables = 0;
        for (String word : words) {
            int syllables = countSyllables(word);
            this.syllables += syllables;
            if (syllables > 2) {
                this.polysyllables++;
            }
        }
    }

    private int countSentences() {
        Matcher matcher = Pattern.compile("[.?!]+\\s*").matcher(this.fullText);
        int count = 0;
        while(matcher.find()) {
            count++;
        }
        if (this.fullText.matches("[\\S\\s]*[^.?!]")) {
            count++;
        }

        return count;
    }

    private int countCharacters() {
        Matcher matcher = Pattern.compile("\\S").matcher(this.fullText);
        int count = 0;
        while(matcher.find()) {
            count++;
        }

        return count;
    }

    private int countSyllables(String word) {
        String vowels = "aeiouy";
        int syllables = 0;
        boolean prevCharIsVowel = false;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (i == word.length() - 1 && currentChar == 'e') {
                break;
            }

            if (vowels.indexOf(currentChar) >= 0) {
                if (! prevCharIsVowel) {
                    syllables++;
                }
                prevCharIsVowel = true;
            } else {
                prevCharIsVowel = false;
            }
        }

        return syllables > 0 ? syllables : 1;
    }

    public String getStats() {
        return String.format("Words: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n",
                this.words,
                this.sentences,
                this.characters,
                this.syllables,
                this.polysyllables);
    }
}
