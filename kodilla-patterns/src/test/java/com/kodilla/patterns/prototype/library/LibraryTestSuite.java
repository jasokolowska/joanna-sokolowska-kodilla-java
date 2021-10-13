package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Biblioteka Miejska");
        Book book1 = new Book("Wzorce projektowe", "Eric Freeman", LocalDate.of(2017,9,30));
        Book book2 = new Book("Czysty kod", "Robert C. Martin", LocalDate.of(2014, 1,1));
        Book book3 = new Book("Miasteczko Surrender", "Caleb Carr", LocalDate.of(2021,8,20));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //making a shallow copy of a library
        Library clonedLibrary = null;
        try{
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of library
        Library deepClonedLibrary = null;
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book2);

        //Then
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
    }
}
