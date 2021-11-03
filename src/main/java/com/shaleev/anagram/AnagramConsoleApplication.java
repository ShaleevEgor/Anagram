package com.shaleev.anagram;

import java.util.Scanner;

public class AnagramConsoleApplication  {
    private static final String INPUT_MESSAGE = "Input string to reverse:";
    private static final String OUTPUT_MESSAGE = "Reversed string: ";

    public static void main(String[] args) {
        AnagramMaker anagram = new AnagramMaker();
        String text = readText();
        String reversedText = anagram.makeAnagram(text);
        System.out.println(OUTPUT_MESSAGE);
        System.out.println(reversedText);
    }

    public static String readText() {
        Scanner in = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        return in.nextLine();
    }
}
