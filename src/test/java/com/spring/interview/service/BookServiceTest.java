package com.spring.interview.service;

import com.spring.interview.dto.BookResponseDTO;
import com.spring.interview.model.Book;
import com.spring.interview.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    /**
     * Test case for getting a book by its id.
     * The test case mocks the BookRepository to return a specific book when findById is called.
     * It then calls the getBook method and checks if the result matches the expected book.
     */
    @Test
    public void shouldGetBookById() {
        String id = "1";
        Book book = new Book(id, "Amintiri din programare", "Mihai Eminescu", 120);

        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        BookResponseDTO result = bookService.getBook(id);

        assertNotNull(result);
        assertEquals(new BookResponseDTO(book.getName(), book.getAuthor(), book.getPrice()), result);
    }

    /**
     * Test case for getting a book by its id when the book does not exist.
     * The test case mocks the BookRepository to return an empty Optional when findById is called.
     * It then calls the getBook method and checks if the result is null.
     */
    @Test
    public void shouldGetNullBookById() {
        String id = "1";

        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.empty());
        BookResponseDTO result = bookService.getBook(id);

        assertNull(result);
    }

}