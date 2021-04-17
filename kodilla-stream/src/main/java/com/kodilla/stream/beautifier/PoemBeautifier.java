package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String stringToDecorate, PoemDecorator poemDecorator) {

        String stringToPrint = poemDecorator.decorate(stringToDecorate);
        System.out.println(stringToPrint);
    }
}
