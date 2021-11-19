package com.shaleev.anagram;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class AnagramMakerTest {
    private final AnagramMaker anagramMaker = new AnagramMaker();

    @Test
    public void makeAnagramShouldReturnAnagramForOneWordSentenceJustWithLetters() {
        String actual = anagramMaker.makeAnagram("Egor");
        String expected = "rogE";

        assertEquals(actual, expected);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void makeAnagramShouldThrowExceptionIfNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("text is null");
        anagramMaker.makeAnagram(null);
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenEmpty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("text is empty");
        anagramMaker.makeAnagram("").isEmpty();
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenSingleSpace() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("text contains only spaces or/and tabs");
        anagramMaker.makeAnagram("  ");
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenSingleChar() {
        String actual = anagramMaker.makeAnagram("q");
        String expected = "q";

        assertEquals(actual, expected);
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenMultipleLetter() {
        String actual = anagramMaker.makeAnagram("eeeee");
        String expected = "eeeee";

        assertEquals(actual, expected);
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenSingleCharSameCharacterLowerUpperCases() {
        String actual = anagramMaker.makeAnagram("qqqqEEEE");
        String expected = "EEEEqqqq";

        assertEquals(actual, expected);
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenOnlySymbols() {
        String actual = anagramMaker.makeAnagram("123");
        String expected = "123";

        assertEquals(actual, expected);
    }

    @Test
    public void makeAnagramShouldReturnSomethingWhenSeveralWords() {
        String actual = anagramMaker.makeAnagram("Egor Shaleev");
        String expected = "rogE veelahS";

        assertEquals(actual, expected);
    }
}
