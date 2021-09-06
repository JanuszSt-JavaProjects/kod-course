package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {


    @Test
    void publicationYearMedianTest() {

        // Given
        Book book1 = new Book("Johny Blask", "Blakcing", 2000, "1--0");
        Book book2 = new Book("Anthony Night", "The Night", 2010, "2--0");
        Book book3 = new Book("Melissa Sin", "Singing", 2020, "3--0");

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(books);

        //Then
        Assertions.assertEquals(2010, publicationYearMedian);
    }
}
