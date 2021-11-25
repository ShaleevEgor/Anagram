package com.shaleev.anagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {
    private final AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    void makeAnagramShouldReturnAnagramForOneWordSentenceJustWithLetters() {
        String actual = anagramMaker.makeAnagram("Egor");
        String expected = "rogE";

        assertEquals(actual, expected);
    }

    @Test
    void makeAnagramShouldThrowExceptionIfNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> anagramMaker.makeAnagram(null));
        assertEquals("text is null", exception.getMessage());
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> anagramMaker.makeAnagram(""));
        assertEquals("text is empty", exception.getMessage());
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenSingleSpace() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> anagramMaker.makeAnagram("  "));
        assertEquals("text contains only spaces or/and tabs", exception.getMessage());
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenSingleChar() {
        String actual = anagramMaker.makeAnagram("q");
        String expected = "q";

        assertEquals(actual, expected);
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenMultipleLetter() {
        String actual = anagramMaker.makeAnagram("eeeee");
        String expected = "eeeee";

        assertEquals(actual, expected);
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenSingleCharSameCharacterLowerUpperCases() {
        String actual = anagramMaker.makeAnagram("qqqqEEEE");
        String expected = "EEEEqqqq";

        assertEquals(actual, expected);
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenOnlySymbols() {
        String actual = anagramMaker.makeAnagram("123");
        String expected = "123";

        assertEquals(actual, expected);
    }

    @Test
    void makeAnagramShouldReturnSomethingWhenSeveralWords() {
        String actual = anagramMaker.makeAnagram("Egor Shaleev");
        String expected = "rogE veelahS";

        assertEquals(actual, expected);
    }
}
