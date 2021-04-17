package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello World ;-)", stringToDecorate -> stringToDecorate.toUpperCase());
        poemBeautifier.beautify("-DEFG-", stringToDecorate -> "ABC" + stringToDecorate + "ABC");
        poemBeautifier.beautify("What a sunny Day!", stringToDecorate -> "~ ".concat(stringToDecorate).concat(" ~"));
        poemBeautifier.beautify("java is better than Haskell", stringToDecorate -> stringToDecorate.substring(0, 4).toUpperCase().concat("!"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }
}