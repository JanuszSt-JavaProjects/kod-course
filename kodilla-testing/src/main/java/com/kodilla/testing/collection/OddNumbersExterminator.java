package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("ERROR! Input List is empty!");
            return numbers;
        } else {
            List<Integer> evenNumbersList = new ArrayList<>();
            for (Integer element : numbers) {
                if ((element % 2) == 0) {
                    evenNumbersList.add(element);
                }
            }
            return evenNumbersList;
        }
    }
}