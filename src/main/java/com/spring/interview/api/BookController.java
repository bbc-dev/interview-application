package com.spring.interview.api;

import com.spring.interview.dto.BookResponseDTO;
import com.spring.interview.dto.ReviewRequestDTO;
import com.spring.interview.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    /*
       Adds a new review for a specified book.
       Endpoint: /books/{id}/review

       @param id The ID of the book to which the review will be added.
       @param bookRequestDTO The review details that need to be saved.
      * @return 201 (Created) if the review is successfully created.
      *         404 (Not Found) if the specified book does not exist.
    */
    @PostMapping("{id}/reviews")
    public ResponseEntity<?> addReview(@PathVariable String id, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        // Implement the method to add a review
        return null;
    }

    /*
     * Retrieves all reviews for a specified book.
     * Endpoint: /books/{id}/reviews
     *
     * @param id The ID of the book for which reviews are requested.
     * @return 200 (OK) if the reviews are successfully retrieved, along with a list of reviews.
     *         An empty list if there are no reviews for the specified book.
    */
    @GetMapping("{id}/reviews")
    public ResponseEntity<?> getReviews(@PathVariable String id) {
        // Implement the method to get all reviews for a book
        return null;
    }
}
