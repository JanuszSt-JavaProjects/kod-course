package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello World ;-)", stringToDecorate -> stringToDecorate.toUpperCase());
        poemBeautifier.beautify("-DEFG-", stringToDecorate -> "ABC" + stringToDecorate + "ABC");
        poemBeautifier.beautify("What a sunny Day!", stringToDecorate -> "~ ".concat(stringToDecorate).concat(" ~"));
        poemBeautifier.beautify("java is better than Haskell", stringToDecorate -> stringToDecorate.substring(0, 4).toUpperCase().concat("!"));
    }
}