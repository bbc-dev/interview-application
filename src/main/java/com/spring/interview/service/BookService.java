package com.spring.interview.service;

import com.spring.interview.dto.BookResponseDTO;
import com.spring.interview.model.Book;
import com.spring.interview.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for handling book related operations.
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Retrieves a book by its id and converts it to a BookResponseDTO.
     * If the book is not found, it returns null.
     *
     * @param id the id of the book to retrieve
     * @return a BookResponseDTO representing the book, or null if the book is not found
     */
    public BookResponseDTO getBook(String id) {
        return bookRepository.findById(id)
                .map(this::convertToBookResponseDTO)
                .orElse(null);
    }

    /**
     * Converts a Book entity to a BookResponseDTO.
     *
     * @param book the Book entity to convert
     * @return a BookResponseDTO representing the book
     */
    private BookResponseDTO convertToBookResponseDTO(Book book) {
        return new BookResponseDTO(book.getName(), book.getAuthor(), book.getPrice());
    }
}