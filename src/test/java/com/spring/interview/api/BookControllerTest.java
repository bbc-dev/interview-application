package com.spring.interview.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.interview.dto.BookResponseDTO;
import com.spring.interview.dto.ReviewRequestDTO;
import com.spring.interview.dto.ReviewResponseDTO;
import com.spring.interview.service.BookService;
import com.spring.interview.service.ReviewService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private ReviewService reviewService;



    /**
     * Test case for getting a book by its id.
     * The test case mocks the BookService to return a specific book when getBook is called.
     * It then performs a GET request to the /books/{id} endpoint and checks if the response is correct.
     */
    @Test
    public void shouldGetBookById() throws Exception {
        String id = "1";

        BookResponseDTO bookResponseDTO = new BookResponseDTO("Amintiri din programare", "Mihai Eminescu", 120);
        Mockito.when(bookService.getBook(id)).thenReturn(bookResponseDTO);

        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(bookResponseDTO.name())));
    }


    /**
     * Test case for getting a book by its id when the book does not exist.
     * The test case mocks the BookService to return null when getBook is called.
     * It then performs a GET request to the /books/{id} endpoint and checks if the response is correct.
     */
    @Test
    public void shouldGetBookByIdNullBook() throws Exception {
        String id = "1";

        Mockito.when(bookService.getBook(id)).thenReturn(null);

        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().isOk());
    }


    /**
     * Test case for adding a new review to a book.
     * The test case mocks the ReviewService to return a specific review id when addReview is called.
     * It then performs a POST request to the /books/{id}/review endpoint and checks if the response is correct.
     */
    @Test
    public void shouldAddNewReview() throws Exception {
        String id = "1";
        String reviewId = "2";
        ReviewRequestDTO reviewRequestDTO = new ReviewRequestDTO("Is good", "john_123");

        Mockito.when(reviewService.addReview(reviewRequestDTO, id)).thenReturn(reviewId);


        ObjectMapper objectMapper = new ObjectMapper();
        String reviewJson = objectMapper.writeValueAsString(reviewRequestDTO);

        mockMvc.perform(post("/books/{id}/review", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reviewJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", is(reviewId)));
    }



    /**
     * Test case for adding a review to a book that does not exist.
     * The test case mocks the ReviewService to throw an IllegalArgumentException when addReview is called.
     * It then performs a GET request to the /books/{id}/review endpoint and checks if the response is correct.
     */
    @Test
    public void shouldGive404OnAddReview() throws Exception {
        String id = "1";
        ReviewRequestDTO review = new ReviewRequestDTO("Is good", "john_123");

        Mockito.when(reviewService.addReview(review, id)).thenThrow(IllegalArgumentException.class);

        mockMvc.perform(get("/books/{id}/review", id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", equalTo("Book not found!")));
    }



    /**
     * Test case for getting the reviews of a book.
     * The test case mocks the ReviewService to return a list of reviews when getReviews is called.
     * It then performs a GET request to the /books/{id}/reviews endpoint and checks if the response is correct.
     */
    @Test
    public void shouldGetBookReviews() throws Exception {
        String id = "1";
        List<ReviewResponseDTO> reviews = List.of(
                new ReviewResponseDTO("1", "good", "mikw_0034", LocalDateTime.now()),
                new ReviewResponseDTO("2", "not good", "alala_john", LocalDateTime.now())
        );

        Mockito.when(reviewService.getReviews(id)).thenReturn(reviews);

        mockMvc.perform(get("/books/{id}/reviews", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].id", is(reviews.get(1).id())));
    }


}
