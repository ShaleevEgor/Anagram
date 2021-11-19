package com.shaleev.anagram;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnagramMaker {
    private static final String DELIMITER = " ";

    public String makeAnagram(String text) {
        validateSentence(text);
        String[] words = text.split(DELIMITER);
        return Arrays.stream(words).map(this::reverseWord).collect(Collectors.joining(DELIMITER));
    }

    private static void validateSentence(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is null");
        }
        if(text.isEmpty()) {
            throw new IllegalArgumentException("text is empty");
        }
        if(text.trim().isEmpty()) {
            throw new IllegalArgumentException("text contains only spaces or/and tabs");
        }
    }

    private String reverseWord(String word) {
        char[] wordCharacters = word.toCharArray();
        int startIndex = 0;
        int endIndex = wordCharacters.length - 1;
        while (startIndex < endIndex) {
            if (!Character.isAlphabetic(wordCharacters[startIndex])) {
                startIndex++;
            } else if (!Character.isAlphabetic(wordCharacters[endIndex])) {
                endIndex--;
            } else {
                swapItems(startIndex, endIndex, wordCharacters);
                endIndex--;
                startIndex++;
            }
        }
        return String.valueOf(wordCharacters);
    }

    private void swapItems(int startIndex, int endIndex, char[] wordCharacters) {
        char current = wordCharacters[startIndex];
        wordCharacters[startIndex] = wordCharacters[endIndex];
        wordCharacters[endIndex] = current;
    }
}
