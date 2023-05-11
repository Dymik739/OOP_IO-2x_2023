package lab3;

import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class WordCounter {
    private String word;
    private int counter = 0;

    public void main() {}

    public WordCounter(String word) {
        this.word = word;
    }

    public void increment() {
        this.counter += 1;
    }

    public String get_word() {
        return this.word;
    }

    public int get_result() {
        return this.counter;
    }
}


/**
 * Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.
 */
public class Variant0 {
    public static void main(String[] args) {
        String textString = "A, a. B a. B a? B a! Ccccc.";
        final String[] sentencesStrings = textString.split("\\[.?!] ?");

        for (String sentencesString : sentencesStrings) {
            System.out.println(sentencesString);
        }

        ArrayList<WordCounter> wordCounter = new ArrayList<WordCounter>();

        for (String sentence : sentencesStrings) {
            String[] localWords = sentence.split(",? ");

word_adder:for (String word : localWords) {
                for (WordCounter w : wordCounter) {
                    if (w.get_word().equals(word)) {
                        break word_adder;
                    }

                    wordCounter.add(new WordCounter(word));
                }
            }
        }

        for (String sentence : sentencesStrings) {
            Set<String> localWords = new HashSet(Arrays.asList(sentence.split(",? ")));
            
            for (WordCounter wc : wordCounter) {
                if (localWords.contains(wc.get_word())) {
                    wc.increment();
                }
            }
        }
        
        WordCounter mostFrequentWord = new WordCounter("123");
        boolean frequencyRepeats = false;

        for (WordCounter wc : wordCounter) {
            if (mostFrequentWord.get_result() > wc.get_result()) {
                mostFrequentWord = wc;
                frequencyRepeats = false;
            } else if (mostFrequentWord.get_result() == wc.get_result()) {
                frequencyRepeats = true;
            }

        }
        
        if (frequencyRepeats) {
            System.out.println("Multiple words can be selected!");
        } else {
            System.out.println("Most frequent word: " + mostFrequentWord.get_result());
        }

//        System.out.println(Arrays.toString(sentencesStrings));
        System.out.println("++++++++++++");
    }
}
