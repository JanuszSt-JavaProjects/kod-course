package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library implements Cloneable {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Library clone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }


    public Library shallowCopy() throws CloneNotSupportedException {
        return this.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library newLibrary = this.clone();
        newLibrary.books = new HashSet<>(books);
        return newLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(getName(), library.getName()) && Objects.equals(getBooks(), library.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBooks());
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}