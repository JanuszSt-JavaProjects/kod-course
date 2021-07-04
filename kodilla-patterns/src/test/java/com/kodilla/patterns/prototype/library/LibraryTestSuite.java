package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    Library library = new Library("First Lib.");
    Book book1 = new Book("1Title", "1 Author", LocalDate.of(1988, 10, 10));
    Book book2 = new Book("2Title", "2 Author", LocalDate.of(2000, 2, 2));
    Book book3 = new Book("3Title", "3 Author", LocalDate.of(2001, 4, 5));

    @BeforeEach
    void before() {
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
    }


    @Test
    void testGetBook() {
        //Given
        //When

        //Then
        Assertions.assertEquals(3, library.getBooks().size());
    }


    @Test
    void testShallowCopy() {
        //Given
        Library newLib = null;

        //When
        try {
            newLib = library.shallowCopy();
        } catch (CloneNotSupportedException exception) {
            exception.getCause();
        }

        newLib.setName("Second Library");

        //Then
        assertNotSame(library, newLib);
        assertNotEquals(library, newLib);
        assertNotEquals(library.getName(), newLib.getName());

        assertSame(library.getBooks(), newLib.getBooks());
    }


    @Test
    void testDeepCopy() {
        //Given
        Library newLib = null;
        Set<Integer> libraryHCSet = new HashSet<>();
        Set<Integer> newLibraryHCSet = new HashSet<>();


        //When
        try {
            newLib = library.deepCopy();
        } catch (CloneNotSupportedException exception) {
            exception.getCause();
        }

        for (Book book : library.getBooks()) {
            libraryHCSet.add(book.hashCode());
        }

        for (Book book : newLib.getBooks()) {
            newLibraryHCSet.add(book.hashCode());
        }

        newLib.setName("Second Library");


        //Then
        assertNotSame(library, newLib);
        assertNotEquals(library, newLib);

        assertNotEquals(library.getName(), newLib.getName());

        assertEquals(library.getBooks(), newLib.getBooks());
        assertNotSame(library.getBooks(), newLib.getBooks());


        for (int lHC : libraryHCSet) {
            for (int nLHC : newLibraryHCSet) {
                assertNotSame(lHC, nLHC);
            }
        }


    }
}
