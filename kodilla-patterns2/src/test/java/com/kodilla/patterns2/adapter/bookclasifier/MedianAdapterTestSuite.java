package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    public void testMedianPublicationYear() {
        //Given
        Book book1 = new Book("Stephen King", "Billy Summers", 2020, "2020-X-123");
        Book book2 = new Book("Yuval Harari", "21 lekcji na XXI wiek", 2018, "2018-V-123");
        Book book3 = new Book("Mario Vargas Llosa", "Rozmowa w 'Katedrze'", 1999, "1999-XI-123");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2018, publicationYearMedian);
    }


}