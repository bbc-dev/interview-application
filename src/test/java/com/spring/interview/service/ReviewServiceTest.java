package com.spring.interview.service;

import com.spring.interview.dto.BookResponseDTO;
import com.spring.interview.dto.ReviewRequestDTO;
import com.spring.interview.dto.ReviewResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private ReviewService reviewService;

    /**
     * Test case for adding a new review to a book.
     * The test case mocks the BookService to return a specific book when getBook is called.
     * It then calls the addReview method and checks if the result is not null.
     */
    @Test
    public void shouldAddNewReview() {
        String id = "1";
        BookResponseDTO bookResponseDTO = new BookResponseDTO("Amintiri din programare", "Mihai Eminescu", 120);
        ReviewRequestDTO review = new ReviewRequestDTO("Is good", "john_123");

        Mockito.when(bookService.getBook(id)).thenReturn(bookResponseDTO);

        String result = reviewService.addReview(review, id);

        assertNotNull(result);
    }

    /**
     * Test case for adding a review with a null id.
     * The test case calls the addReview method with a null id and expects an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsException_null_id() {
        ReviewRequestDTO review = new ReviewRequestDTO("Is good", "john_123");

        reviewService.addReview(review, null);
    }

    /**
     * Test case for adding a review to a non-existent book.
     * The test case mocks the BookService to return null when getBook is called.
     * It then calls the addReview method and expects an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsException_null_book() {
        String id = "1";
        ReviewRequestDTO review = new ReviewRequestDTO("Is good", "john_123");

        Mockito.when(bookService.getBook(id)).thenReturn(null);

        reviewService.addReview(review, id);
    }

    /**
     * Test case for getting the reviews of a book.
     * The test case mocks the BookService to return a specific book when getBook is called.
     * It then calls the getReviews method and checks if the result matches the expected reviews.
     */
    @Test
    public void shouldGetBookComments() {
        String id = "1";
        BookResponseDTO bookResponseDTO = new BookResponseDTO("Amintiri din programare", "Mihai Eminescu", 120);
        List<ReviewResponseDTO> reviews = List.of(
                new ReviewResponseDTO("1", "good", "mikw_0034", LocalDateTime.now()),
                new ReviewResponseDTO("2", "not good", "alala_john", LocalDateTime.now())
        );

        Mockito.when(bookService.getBook(id)).thenReturn(bookResponseDTO);

        List<ReviewResponseDTO> result = reviewService.getReviews(id);

        assertNotNull(result);
        assertEquals(result.size(), reviews.size());
    }

    /**
     * Test case for getting the reviews of a book with no reviews.
     * The test case calls the getReviews method with a specific id and checks if the result is an empty list.
     */
    @Test
    public void shouldGetEmptyList() {
        String id = "1";

        List<ReviewResponseDTO> result = reviewService.getReviews(id);

        assertNotNull(result);
        assertEquals(result.size(), 0);
    }
}